<?xml version="1.0" encoding="UTF-8"?>
<Message>
    <Head>
        <TrsCode>${TrsCode}</TrsCode>
    </Head>
    <Body>
    <BList>
        <#--<RespData>-->
        <#--<ReturnCode>${ReturnCode}</ReturnCode>-->
        <#--</RespData>-->
        <#if BList?? && (BList?size > 0) >
            <#list BList as data>
                <RespData>
                <ReturnCode>${data.ReturnCode}</ReturnCode>
                </RespData>
            </#list>
        </#if>
    </BList>


    </Body>
</Message>