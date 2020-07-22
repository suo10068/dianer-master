<?xml version="1.0" encoding="UTF-8"?>
<FOX>
    <SIGNONMSGSRQV1>
        <SONRQ>
            <DTCLIENT>${DTCLIENT!""}</DTCLIENT>
            <CID>${CID!""}</CID>
            <USERID>${USERID!""}</USERID>
            <USERPASS>${USERPASS!""}</USERPASS>
            <GENUSERKEY>${GENUSERKEY!"N"}</GENUSERKEY>
            <APPID>${APPID!""}</APPID>
            <APPVER>${APPVER!""}</APPVER>
        </SONRQ>
    </SIGNONMSGSRQV1>
    <SECURITIES_MSGSRQV1>
        <RBATCHTRSFRTRNRQ>
            <TRNUID>${TRNUID!""}</TRNUID>
            <RQBODY>
                <TITLE>${TITLE!""}</TITLE>
                <ACCTFROM>
                    <ACCTID>${ACCTID!""}</ACCTID>
                    <NAME>${NAME!""}</NAME>
                    <BANKDESC>${BANKDESC!""}</BANKDESC>
                    <CITY>${CITY!""}</CITY>
                </ACCTFROM>
                <BIZTYPE>${BIZTYPE!"0"}</BIZTYPE>
                <TOTALCOUNT>${TOTALCOUNT!""}</TOTALCOUNT>
                <TOTALAMOUNT>${TOTALAMOUNT!""}</TOTALAMOUNT>
                <CHEQUENUM>${CHEQUENUM!""}</CHEQUENUM>
                <CURSYM>${CURSYM!"RMB"}</CURSYM>
                <PURPOSE>${PURPOSE!""}</PURPOSE>
                <DTDUE>${DTDUE!""}</DTDUE>
                <MEMO>${MEMO!""}</MEMO>

                <#list List as RCV>
                    <XFERINFO>
                        <INDX>${RCV.INDX}</INDX>
                        <ACCTTO INTERBANK='${RCV.INTERBANK}' LOCAL='${RCV.LOCAL}'>
                            <ACCTID>${RCV.ACCTID}</ACCTID>
                            <NAME>${RCV.NAME}</NAME>
                            <BANKDESC>${RCV.BANKDESC}</BANKDESC>
                            <BANKNUM>${RCV.BANKNUM}</BANKNUM>
                            <CITY>${RCV.CITY}</CITY>
                        </ACCTTO>
                        <TRNAMT>${RCV.TRNAMT}</TRNAMT>
                    </XFERINFO>
                </#list>

            </RQBODY>
        </RBATCHTRSFRTRNRQ>
    </SECURITIES_MSGSRQV1>
</FOX>