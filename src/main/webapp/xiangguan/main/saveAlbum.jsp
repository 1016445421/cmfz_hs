<%@page pageEncoding="UTF-8" language="java"  isELIgnored="false" %>

<div style="text-align: center;">
    <form id="openAlbumSave" class="easyui-form" method="post" enctype="multipart/form-data">
        <input type="hidden" name="id">
        <div style="margin-top:50px;">
            名字: <input type="text" name="title" class="easyui-textbox" data-options="required:true">
        </div>
       <div style="margin-top: 20px;">
            发表日期: <input type="text" name="publishDate" class="easyui-datebox">
        </div>
        <div style="margin-top: 20px;">
            集数: <input type="text" name="count" class="easyui-textbox">
        </div>
        <div style="margin-top: 20px;">
            上传路径: <input type="text" name="coveringPath" class="easyui-filebox">
        </div>
        <div style="margin-top: 20px;">
            评分: <input type="text" name="star" class="easyui-textbox">
        </div>
       <div style="margin-top: 20px;">
            作者: <input type="text" name="author" class="easyui-textbox">
        </div>
        <div style="margin-top: 20px;">
            播音: <input type="text" name="broabcast" class="easyui-textbox">
        </div>
        <div style="margin-top: 20px;">
            简介: <input type="text" name="brief" class="easyui-textbox">
        </div>

    </form>
</div>

