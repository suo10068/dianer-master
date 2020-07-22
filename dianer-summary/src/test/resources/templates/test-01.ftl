<?xml version="1.0" encoding="UTF-8"?>
<Message>
    <Head>
        <TrsCode>${TrsCode}</TrsCode>
    </Head>
    <Body>
    <#if BList?? && (BList?size > 0) >
        <#list BList as data>
            <No>${num}</No>
            <RespData Kye="${num}" Value="${num}">
            <ReturnCode>${data.ReturnCode!"DDDDD"}</ReturnCode>
            </RespData>
        </#list>
    </#if>


    </Body>
</Message>