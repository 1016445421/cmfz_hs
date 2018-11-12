<%@page pageEncoding="UTF-8"  isELIgnored="false" %>


<div style="text-align: center;">
    <form id="update2" class="easyui-form" method="post">
        <input type="hidden" name="id" value="${sessionScope.id}">
        <div style="margin-top:70px;">
            原&nbsp;&nbsp;&nbsp;密&nbsp;&nbsp;&nbsp;码: <input type="text" name="password"  class="easyui-textbox" data-options="required:true">
        </div>
        <div style="margin-top: 20px;">
            新&nbsp;&nbsp;&nbsp;密&nbsp;&nbsp;&nbsp;码: <input type="text" name="password1" class="easyui-textbox">
        </div>


    </form>
</div>

