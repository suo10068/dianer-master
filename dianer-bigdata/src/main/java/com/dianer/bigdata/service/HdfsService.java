package com.dianer.bigdata.service;

import com.dianer.bigdata.config.HadoopTemplate;
import com.dianer.bigdata.config.MyPathFilter;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.PrintStream;

@Service
public class HdfsService {
    @Autowired
    HadoopTemplate template;
    @Autowired
    private FileSystem fileSystem;

    public void merge() throws IOException {
        Path inputPath, outputPath;
//        FileSystem.get()
        FileStatus[] inputFileStatuses = fileSystem.listStatus(new Path("/user/data/input"), new MyPathFilter(".*\\.txt"));

        for (FileStatus fs : inputFileStatuses) {
            System.out.println("路径：" + fs.getPath() + "大小：" + fs.getLen() + "权限：" + fs.getPermission());

            FSDataInputStream fsDataInputStream = fileSystem.open(fs.getPath());
            byte[] data = new byte[1024];
            int read = -1;
            PrintStream ps = new PrintStream(System.out);
            while ((read = fsDataInputStream.read(data)) > 0) {
                ps.write(data, 0, read);
            }
            ps.close();
            fsDataInputStream.close();
        }

    }


}
