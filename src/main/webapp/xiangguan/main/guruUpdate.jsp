<%@page pageEncoding="UTF-8" language="java"  isELIgnored="false" %>
   <script>
        $(function () {
            console.log("${param.id}");
            $("#GuruEdit").form('load','${pageContext.request.contextPath}/guru/findOne?id=${param.id}');
        })
    </script>

<div style="text-align: center;">
    <form id="GuruEdit" class="easyui-form" method="post" enctype="multipart/form-data">
        <input type="hidden" name="id">
        <div style="margin-top:50px;">
            名字: <input type="text" name="name" class="easyui-textbox" data-options="required:true">
        </div>
        <div style="margin-top: 20px;">
            头像: <input type="text" name="headPic" class="easyui-textbox"><br>
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input name="headPicPath" class="easyui-filebox">
        </div>
        <div style="margin-top: 20px;">
            性别: <input type="text" name="sex" class="easyui-textbox">
        </div>
        <%--<div style="margin-top: 20px;">
            时间: <input type="text" name="days" class="easyui-datebox">
        </div>--%>
    </form>
</div>

