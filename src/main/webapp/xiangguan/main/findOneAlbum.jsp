<%@page pageEncoding="UTF-8" language="java"  isELIgnored="false" %>
<script>

    $(function () {
        var parse = ${param.jQuery};
        document.getElementById("aa").innerHTML="<img align=\"left\" src=\"${pageContext.request.contextPath}/photo/mv/"+parse.covering+"\" style='margin-left:50px;margin-top:10px;width:150px;height:220px;border:1px solid #0000ff' />"+
            "<p>作者："+parse.author+"</p>" +
            "<p>播音："+parse.broabcast+"</p>" +
            "<p>封面名称："+parse.title+"</p>" +
            "<p>星级："+parse.star+"</p>" +
            "<p>集数："+parse.count+"</p>"+
            "<p>发布日期："+parse.publishDate+"</p>"+
            "<p>内容："+parse.brief+"</p>";
    })
</script>
<div id="aa" style="text-align: center;">

</div>

