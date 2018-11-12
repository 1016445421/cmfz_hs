<%@page pageEncoding="UTF-8" language="java"  isELIgnored="false" %>

<div style="text-align: center;">
    <form id="openBannerSave" class="easyui-form" method="post" enctype="multipart/form-data">
        <input type="hidden" name="id">
        <div style="margin-top:50px;">
            名字: <input type="text" name="title" class="easyui-textbox" data-options="required:true">
        </div>
        <div style="margin-top: 20px;">
            路径: <input type="text" name="imagePath" class="easyui-filebox">
        </div>
        <div style="margin-top: 20px;">
            描述: <input type="text" name="descc" class="easyui-textbox">
        </div>

        <div style="margin-top: 20px;">
            状态: <input type="text" name="status" class="easyui-textbox">
        </div>
       <div style="margin-top: 20px;">
            时间: <input type="text" name="days" class="easyui-datebox">
        </div>
    </form>
</div>

