<%@page pageEncoding="UTF-8" language="java"  isELIgnored="false" %>
<script>
    $("#cc").combobox({
        url:'${pageContext.request.contextPath}/album/All',
        valueField:'id',
        textField:'title'
    });
</script>
<div style="text-align: center;">
    <form id="openChapterSave" class="easyui-form" method="post" enctype="multipart/form-data">
        <input type="hidden" name="id">
        <div style="margin-top:50px;">
    名&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;字: <input type="text" name="title" class="easyui-textbox" data-options="required:true">
        </div>
        <div style="margin-top: 20px;">
            上传路径: <input type="text" name="downsPath" class="easyui-filebox"><br><br>
        </div>
        制定专辑:<input id="cc" name="album_id">


    </form>
</div>

