<%@page pageEncoding="UTF-8" language="java"  isELIgnored="false" %>
   <script>
        $(function () {
            console.log("${param.id}");
            $("#openBannerEdit").form('load','${pageContext.request.contextPath}/banner/findOne?id=${param.id}');
        })
    </script>

<div style="text-align: center;">
    <form id="openBannerEdit" class="easyui-form" method="post" enctype="multipart/form-data">
        <input type="hidden" name="id">
        <div style="margin-top:50px;">
            名字: <input type="text" name="title" class="easyui-textbox" data-options="required:true">
        </div>
        <div style="margin-top: 20px;">
            状态: <input type="text" name="status" class="easyui-textbox">
        </div>
        <div style="margin-top: 20px;">
            路径: <input type="text" name="imagePath" class="easyui-filebox"><br>
<%--&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input name="imagePath" class="easyui-filebox">--%>
        </div>
        <div style="margin-top: 20px;">
            时间: <input type="text" name="days" class="easyui-datebox">
        </div>
    </form>
</div>

