<!DOCTYPE html>
<html lang="cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>角色管理表格</title>
    <!-- jqGrid组件基础样式包-必要 -->
    <link href="${basePath!}/static/jqgrid/css/ui.jqgrid.css" type="text/css" media="screen" rel="stylesheet"/>
    <link href="${basePath!}/static/jqgrid/css/jquery-ui.css" type="text/css" media="screen" rel="stylesheet"/>
    <link href="${basePath!}/static/css/global.css" type="text/css" media="screen" rel="stylesheet"/>
    <link href="${basePath!}/static/plugins/font-awesome/css/font-awesome.min.css" type="text/css" media="screen"
          rel="stylesheet"/>
    <link href="${basePath!}/static/layui/css/layui.css" type="text/css" media="screen" rel="stylesheet"/>
    <link href="${basePath!}/static/css/ztree/metroStyle/metroStyle.css" type="text/css" media="screen"
          rel="stylesheet"/>
    <link href="${basePath!}/static/css/ztree/demo.css" type="text/css" media="screen" rel="stylesheet"/>

    <!-- jquery插件包-必要 -->
    <!-- 这个是所有jquery插件的基础，首先第一个引入 -->
    <script src="${basePath!}/static/js/jquery.min.js" type="text/javascript"></script>
    <script src="${basePath!}/static/jqgrid/js/jquery.jqGrid.min.js" type="text/javascript"></script>
    <!-- jqGrid插件的多语言包-非必要 -->
    <!-- 在jqgrid/js/i18n下还有其他的多语言包，可以尝试更换看效果 -->
    <script src="${basePath!}/static/jqgrid/js/i18n/grid.locale-cn.js" type="text/javascript"></script>
    <script src="${basePath!}/static/jqgrid/js/jquery-ui.js" type="text/javascript"></script>
    <script src="${basePath!}/static/layui/layui.js" type="text/javascript"></script>
    <script src="${basePath!}/static/layui/lay/modules/upload.js" type="text/javascript"></script>
    <script src="${basePath!}/static/js/ztree/jquery.ztree.all.js" type="text/javascript"></script>


    <base href="${basePath!}/">

</head>
<body>
<div class="layui-btn-group">
    <button class="layui-btn" id="add">增加</button>
    <button class="layui-btn" id="edit">编辑</button>
    <button class="layui-btn" id="delete">删除</button>
    <#--<button class="layui-btn" id="upload">上传</button>-->
</div>

<table id="list2"></table>
<div id="pager2"></div>

<#--↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓upload↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓-->
<#--带有 class="layui-fluid" 的容器中，那么宽度将不会固定，而是 100% 适应-->
<#--<div id="uploadformdivid" hidden="" class="layui-fluid" style="margin: 15px;">-->
    <#--<form class="layui-form" action="" id="uploadformid">-->
        <#--<label hidden="true" id="uploadlabelid"></label>-->
        <#--<input id="uploadid" name="id" value="" hidden/>-->
        <#--<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">-->
            <#--<legend>选完文件后不自动上传</legend>-->
        <#--</fieldset>-->

        <#--<div class="layui-upload">-->
            <#--<button type="button" class="layui-btn layui-btn-normal" id="test8">选择文件</button>-->
            <#--<button type="button" class="layui-btn" id="test9">开始上传</button>-->
        <#--</div>-->
    <#--</form>-->
<#--</div>-->
<#--↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑upload↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑-->

<#--↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓add↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓-->
<#--带有 class="layui-fluid" 的容器中，那么宽度将不会固定，而是 100% 适应-->
<div id="addeditformdivid" hidden="" class="layui-fluid" style="margin: 15px;">
    <form class="layui-form" action="" id="addeditformid">
        <label hidden="true" id="editlabelid"></label>
        <input id="editid" name="id" value="" hidden/>
    <#--    <input type="text"  id="startLiveTime" name="startLiveTime"  hidden="true"/>
        <input type="text"  id="endLiveTime"   name="endLiveTime"  hidden="true"/>-->
        <#--单选-->
        <div class="layui-form-item">
            <label class="layui-form-label">单选框</label>
            <div class="layui-input-block">
                <input type="radio" name="onlyChoice"  id="onlyChoice" value="1" title="男" checked="">
                <input type="radio" name="onlyChoice"  id="onlyChoice" value="2" title="女">
            </div>
        </div>
        <div class="layui-form-item" pane="">
            <label class="layui-form-label">复选框</label>
            <div class="layui-input-block">
                <input type="checkbox" name="checkbox" lay-skin="primary" value="1" title="写作" checked="">
                <input type="checkbox" name="checkbox" lay-skin="primary" value="2" title="阅读">
                <input type="checkbox" name="checkbox" lay-skin="primary" value="3" title="游戏" disabled="">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">搜索选择框</label>
            <div class="layui-input-inline">
                <select name="selectChoice" id="selectChoice" lay-verify="required" lay-search="">
                    <option value="">直接选择或搜索选择</option>
                    <option value="1">layer</option>
                    <option value="2">form</option>
                    <option value="3">layim</option>
                    <option value="4">element</option>
                    <option value="5">laytpl</option>
                    <option value="6">upload</option>
                    <option value="7">laydate</option>
                    <option value="8">laypage</option>
                    <option value="9">flow</option>
                </select>
            </div>
        </div><br/>
        <div class="layui-inline">
            <label class="layui-form-label">开始时间</label>
            <div class="layui-input-inline">
                <input type="text" class="layui-input" id="startLiveTime" name="startLiveTime" id="startLiveTime" />
            </div>

        </div>
        <div class="layui-inline">
            <label class="layui-form-label">结束时间</label>
            <div class="layui-input-inline">
                <input type="text" class="layui-input" id="endLiveTime"   name="endLiveTime"  id="endLiveTime" />
            </div>

        </div>
        <input type="text"  id="resourceName" name="resourceName"  hidden="true"/>
        <input type="text"  id="resourceUploadUrl"   name="resourceUploadUrl"  hidden="true"/>
        <fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
            <legend>选完文件后不自动上传</legend>
        </fieldset>

        <div class="layui-upload">
            <button type="button" class="layui-btn layui-btn-normal" id="test8">选择文件</button>
            <button type="button" class="layui-btn" id="test9">开始上传</button>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit="" lay-filter="addeditsubmitfilter">立即提交</button>
                <button id="reset" type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>

    </form>
</div>
<#--↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑add↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑-->



<#--菜单权限设置弹窗-->
<div id="setpermisdiv" hidden="" class="layui-fluid">
    <ul id="treeDemo" class="ztree"></ul>
    <button class="layui-btn" id="savesetpermis">保存权限设置</button>
    <button class="layui-btn" id="closesetpermis">关闭</button>
    <script type="text/javascript">
        $('#savesetpermis').on('click', function () {

            var id = jQuery("#list2").jqGrid('getGridParam', 'selrow');//jqgrid逻辑id，不是业务表单的主键字段id,这里要注意
            var ret = jQuery("#list2").jqGrid('getRowData', id);//通过jqgrid的逻辑id获取该行数据，通过数据对象ret来获取表单主键字段ret.id


            var nodes = zTreeObj1.getCheckedNodes(true);
            var menuArrIds = [];
            for (var i = 0; i < nodes.length; i++) {
                //alert(menuIds);
                menuArrIds.push(nodes[i].id);
            }
            var menuIds = menuArrIds.join(",");
            //alert(menuIds);

            $.ajax({
                type: "POST",
                url: "admin/role/saveMenuSet",
                data: {menuIds: menuIds, roleId: ret.id},
                async: false,
                error: function (request) {
                    layer.alert("与服务器连接失败/(ㄒoㄒ)/~~");
                },
                success: function (data) {
                    if (data.state == 'fail') {
                        layer.alert(data.mesg);
                    }
                    if (data.state == 'success') {
                        layer.open({
                            skin: 'layui-layer-molv',
                            type: 1,
                            area: "10%",
                            content: data.mesg,
                            shadeClose: true,
                            end: function () {
                                layer.close(layerid);
                                jQuery("#list2").jqGrid().trigger("reloadGrid");//重新加载数据
                                //location.reload();
                                parent.location.reload();
                            }
                        });

                    }
                }
            });

        });
        $('#closesetpermis').on('click', function () {
            layer.close(layerid);
        });
    </script>
</div>


</body>
</html>



<script type="text/javascript">

    var zTreeObj1;
    var zTreeObj2;
    var layerid;//当前弹层id;这个id可以定义多个，主要的目的是为了在回调函数关闭弹层时使用的
    layui.use(['layer', 'form', 'layedit', 'laydate','upload'], function () {
        var layer = layui.layer,
        layedit = layui.layedit,
        laydate = layui.laydate,
        layupload = layui.upload;
        form = layui.form;

        //创建一个编辑器
        var editIndex = layedit.build('LAY_demo_editor');
        //自定义验证规则
        form.verify({
            name: function (value) {
                if (value.length < 5) {
                    return '角色名至少得5个字符';
                }
            },
            password: [/(.+){6,12}$/, '密码必须6到12位'],
            content: function (value) {
                layedit.sync(editIndex);
            }
        });

        //监听(新增)和(编辑)页面中的提交按钮
        form.on('submit(addeditsubmitfilter)', function (data) {

            //为了防止form中的id值被重置后置空,将编辑的id存放在label中
            $("#editid").val($("#editlabelid").html());
            $("#editlabelid").html("");
            console.log($('#addeditformid').serialize());
            $.ajax({
                type: "POST",
                //contentType: "application/json;charset=UTF-8",
                url: "admin/baseInfo/addupdatebaseinfo",
                data: $('#addeditformid').serialize(),
                async: false,
                //dataType:'json',
                error: function (request) {
                    layer.alert("与服务器连接失败/(ㄒoㄒ)/~~");
                },
                success: function (data) {
                    if (data.state == 'fail') {
                        layer.alert(data.mesg);
                    }
                    if (data.state == 'success') {
                        layer.open({
                            skin: 'layui-layer-molv',
                            type: 1,
                            area: "10%",
                            content: data.mesg,
                            shadeClose: true,
                            end: function () {
                                layer.close(layerid);
                                jQuery("#list2").jqGrid().trigger("reloadGrid");//重新加载数据
                                $("#reset").click();//重置表单
                            }
                        });

                    }
                }
            });


            return false;
        });

        //监听设置菜单权限提交
        form.on('submit(editroleformsubmit)', function (data) {
            //为了防止form中的id值被重置后置空,将编辑的id存放在label中
            $("#editroleid").val($("#editrolelabelid").html());
            $("#editrolelabelid").html("");

            $.ajax({
                type: "POST",
                url: "admin/user/saveRoleSet",
                data: $('#editroleformid').serialize(),// 你的formid
                async: false,
                error: function (request) {
                    layer.alert("与服务器连接失败/(ㄒoㄒ)/~~");
                },
                success: function (data) {
                    if (data.state == 'fail') {
                        layer.alert(data.mesg);
                    }
                    if (data.state == 'success') {
                        layer.open({
                            skin: 'layui-layer-molv',
                            type: 1,
                            area: "10%",
                            content: data.mesg,
                            shadeClose: true,
                            end: function () {
                                layer.close(layerid);
                                jQuery("#list2").jqGrid().trigger("reloadGrid");//重新加载数据
                                $("#reset").click();//重置表单
                            }
                        });

                    }
                }
            });


            return false;//防止跳转
        });
        //上传文件
        layupload.render({
            elem: '#test8'
            ,url: '${basePath!}/admin/fileUpload/uploadFile' //注意这里必须要加${basePath!}，不然请求接口会丢失项目/根访问路径/manager
            ,auto: false
            ,accept: 'file'
            //,multiple: true
            ,bindAction: '#test9'
            ,done: function(res){
                $("#resourceName").val(res.fileName);
                $("#resourceUploadUrl").val(res.filePath);
                console.log($("#resourceName").val());
                console.log($("#resourceUploadUrl").val())
                layer.msg('上传成功');

            },
            error: function(){
                layer.msg('上传失败');
            }
        });

        //添加-按钮点击事件
        $("#add").click(function () {
            $("#reset").click();//重置表单(新建时在进入表单前要重置一下表单的内容，不然表单打开后会显示上一次的表单的内容。这里调用表单中重置按钮的点击方法来重置)
            layerid = layer.open({//开启表单弹层
                skin: 'layui-layer-molv',
                area:  ['60%', '50%'],
                type: 1,
                title: '新建基础信息',
                content: $('#addeditformdivid') //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
            });
        });
        //编辑-按钮点击事件
        $("#edit").click(function () {

            var id = jQuery("#list2").jqGrid('getGridParam', 'selrow');//jqgrid逻辑id，不是业务表单的主键字段id,这里要注意
            if (id) {
                var ret = jQuery("#list2").jqGrid('getRowData', id);//通过jqgrid的逻辑id获取该行数据，通过数据对象ret来获取表单主键字段ret.id

                //请求后台，获取该记录的详细记录，并填充进表单
                $.ajax({
                    type: "POST",
                    url: "admin/baseInfo/selectBaseInfoById",
                    data: {id: ret.id},
                    async: false,
                    error: function (request) {
                        layer.alert("与服务器连接失败/(ㄒoㄒ)/~~");
                    },
                    success: function (data) {
                        if (data.state == 'fail') {
                            layer.alert(data.mesg);
                            return false;
                        }
                        if (data.state == 'success') {
                            //向表单填充数据
                            //页面单选按钮静态时候
                            $("input[name=onlyChoice][value=1]").attr("checked", data.baseInfo.onlyChoice == '1' ? true : false);
                            $("input[name=onlyChoice][value=2]").attr("checked", data.baseInfo.onlyChoice == '2' ? true : false);

                            //页面是多选按钮，只选一个时候
                            $("input[name=checkbox][value=1]").attr("checked", data.baseInfo.checkbox == '1' ? true : false);
                            $("input[name=checkbox][value=2]").attr("checked", data.baseInfo.checkbox == '2' ? true : false);
                            $("input[name=checkbox][value=3]").attr("checked", data.baseInfo.checkbox == '3' ? true : false);
                            //页面是静态下拉框时候
                            // 遍历select
                            $("#selectChoice").each(function() {
                                // this代表的是<option></option>，对option再进行遍历
                                $(this).children("option").each(function() {
                                    // 判断需要对那个选项进行回显
                                    if (this.value == data.baseInfo.checkbox) {
                                        console.log($(this).text());
                                        // 进行回显
                                        $(this).attr("selected",true);
                                    }
                                });
                            })
                            $("#startLiveTime").val(data.baseInfo.startLiveTime);
                            $("#endLiveTime").val(data.baseInfo.endLiveTime);
                            form.render(); //更新全部
                            $("#editlabelid").html(ret.id);//临时存放id，当提交时再去除赋值给input
                            //开启编辑表单所在的弹层。注意编辑和新建的表单是一套模板
                            layerid = layer.open({
                                skin: 'layui-layer-molv',
                                area: '60%',
                                type: 1,
                                title: '编辑角色',
                                content: $('#addeditformdivid') //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
                            });

                        }
                    }
                });


            } else {
                layer.alert("请选择要编辑的记录");
            }


        });
        //删除-按钮点击事件
        $("#delete").click(function () {

            var id = jQuery("#list2").jqGrid('getGridParam', 'selrow');//jqgrid逻辑id，不是业务表单的主键字段id,这里要注意
            if (id) {
                var ret = jQuery("#list2").jqGrid('getRowData', id);//通过jqgrid的逻辑id获取该行数据，通过数据对象ret来获取表单主键字段ret.id

                layer.open({
                    content: '请确定是否真的要删除id为' + ret.id + '的记录?',
                    btn: ['yes', 'no'],//定义两个按钮，是和否
                    yes: function (index, layero) {//点击是时候的回调
                        //do something
                        layer.close(index); //如果设定了yes回调，需进行手工关闭

                        //请求后台，执行删除操作
                        $.ajax({
                            type: "POST",
                            url: "admin/role/deleterole",
                            data: {id: ret.id},
                            async: false,
                            error: function (request) {
                                layer.alert("与服务器连接失败/(ㄒoㄒ)/~~");
                            },
                            success: function (data) {
                                if (data.state == 'fail') {
                                    layer.alert(data.mesg);
                                }
                                if (data.state == 'success') {
                                    //打开成功消息提示
                                    layer.open({
                                        skin: 'layui-layer-molv',
                                        type: 1,
                                        area: "10%",
                                        content: data.mesg,
                                        shadeClose: true,
                                        end: function () {
                                            layer.close(layerid);//消息提示结束后回调，关闭上一级新建表单所在弹层
                                            jQuery("#list2").jqGrid().trigger("reloadGrid");//jqgrid数据表重新主动加载数据
                                        }
                                    });

                                }
                            }
                        });


                    }
                });


            } else {
                layer.alert("请选择要删除的记录");
            }


        });
        //上传-按钮点击事件
        // $("#upload").click(function () {
        //     $("#reset").click();//重置表单(新建时在进入表单前要重置一下表单的内容，不然表单打开后会显示上一次的表单的内容。这里调用表单中重置按钮的点击方法来重置)
        //     layerid = layer.open({//开启表单弹层
        //         skin: 'layui-layer-molv',
        //         area:  ['60%', '50%'],
        //         type: 1,
        //         title: '上传文件',
        //         content: $('#uploadformdivid') //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
        //     });
        //
        // });


        $(function () {
            //页面加载完成之后执行
            pageInit();
        });
        //列表初始化
        function pageInit() {
            //创建jqGrid组件
            jQuery("#list2").jqGrid(
                    {
                        caption: "基础信息",//表格的标题名字
                        mtype: "post",//向后台请求数据的ajax的类型。可选post,get
                        url: 'admin/baseInfo/list',
                        //url : 'static/jqgrid/data/JSONData.json',//组件创建完成之后请求数据的url
                        //styleUI: 'Bootstrap',
                        datatype: "json",//请求数据返回的类型。可选json,xml,txt
                        emptyrecords: "当前无记录",
                        colNames: ['ID', '单选', '多选', '下拉', '开始时间', '结束时间', '资源路径'],//jqGrid的列显示名字
                        colModel: [  //这里会根据index去解析jsonReader中root对象的属性，填充cell
                            {name: 'id', index: 'id', width: 100, sortable: true, search: false, align: 'center'},
                            {
                                name: 'onlyChoice',
                                index: 'onlyChoice',
                                width: 10,
                                sortable: false,
                                search: false,
                                align: 'center'
                            },
                            {
                                name: 'checkbox',
                                index: 'checkbox',
                                width: 30,
                                sortable: false,
                                search: false,
                                align: 'center'
                            },
                            {
                                name: 'selectChoice',
                                index: 'selectChoice',
                                width: 10,
                                sortable: false,
                                search: false,
                                align: 'center'
                            },
                            {
                                name: 'startLiveTime',
                                index: 'startLiveTime',
                                width: 50,
                                sortable: false,
                                search: false,
                                align: 'center'
                            },
                            {
                                name: 'endLiveTime',
                                index: 'endLiveTime',
                                width: 50,
                                sortable: false,
                                search: false,
                                align: 'center'
                            },
                            {
                                name: 'resourceUploadUrl',
                                index: 'resourceUploadUrl',
                                width: 200,
                                sortable: false,
                                search: false,
                                align: 'center'
                            },
                        ],

                        //在gridComplete事件中添加：
                        gridComplete: function () {
                            var ids = jQuery("#list2").jqGrid('getDataIDs');
                            for (var i = 0; i < ids.length; i++) {
                                //alert(ids[i]);
                                var id = ids[i];
                                // var editBtn = "<a href='javascript:void(0)' style='color:#f60' onclick='' >设置权限</a>";
                                var editBtn = '<button onclick="setrolelayer(' + ids[i] + ')" class="layui-btn layui-btn-radius layui-btn-xs" style="width:inherit;height: 85%">' +
                                        '<i class="layui-icon">&#xe642;</i>设置菜单权限' +
                                        '</button>';

                                jQuery("#list2").jqGrid('setRowData', ids[i], {setpermis: editBtn});
                            }
                        },

                        //如果使用自定义按钮点击事件的方式进行记录增删改操作的话下可以去掉
                        //editurl: "admin/user/adduser",
                        //cellsubmit: "clientArray",
                        //cellEdit:true,//启用或者禁用单元格编辑功能
                        jsonReader: {
                            root: "datamap",//数据的根节点
                            page: "currpage",//返回数据的当前页
                            total: "totalpages",//总页数
                            records: "totalrecords",//总记录数
                            repeatitems: false,// 如果设为false，则jqGrid在解析json时，会根据name来搜索对应的数据元素（即可以json中元素可以不按顺序）；而所使用的name是来自于colModel中的name设定。
                            id: "id"//主键字段名称
                        },
                        prmNames: { //如当前查询实体为ware，这些可以在查询对象的superObject中设定
                            page: "page", // 表示请求页码的参数名称
                            rows: "length", // 表示请求行数的参数名称
                            sort: "sidx", // 表示用于排序的列名的参数名称
                            order: "sord", // 表示采用的排序方式的参数名称
                            search: "search", // 表示是否是搜索请求的参数名称(实际上在搜索时会传给后台三个参数：String searchField;//搜索字段String searchString;//搜索值String searchOper;//搜索条件公式)
                            nd: "nd", // 表示已经发送请求的次数的参数名称
                            id: "id", // 表示当在编辑数据模块中发送数据时，使用的id的名称
                            oper: "oper", // operation参数名称
                            editoper: "edit", // 当在edit模式中提交数据时，操作的名称
                            addoper: "add", // 当在add模式中提交数据时，操作的名称
                            deloper: "del", // 当在delete模式中提交数据时，操作的名称
                            subgridid: "id", // 当点击以载入数据到子表时，传递的数据名称
                            npage: null,
                            totalrows: "totalrows" // 表示需从Server得到总共多少行数据的参数名称，参见jqGrid选项中的rowTotal
                        },
                        rowNum: 10,//一页显示多少条
                        rowList: [10, 20, 30],//可供用户选择一页显示多少条
                        pager: '#pager2',//表格页脚的占位符(一般是div)的id
                        sortname: 'id',//初始化的时候排序的字段
                        sortorder: "asc",//排序方式,可选desc,asc
                        viewrecords: true,//定义是否要显示总记录数
                        hidegrid: false,//启用或者禁用控制表格显示、隐藏的按钮，只有当caption 属性不为空时起效
                        height: "100%",
                        autowidth: true,//如果为ture时，则当表格在首次被创建时会根据父元素比例重新调整表格宽度。如果父元素宽度改变，为了使表格宽度能够自动调整则需要实现函数：setGridWidth
                        shrinkToFit: true,
                        rownumbers: true // 显示行号
                    });
            /*创建jqGrid的操作按钮容器*/
            /*可以控制界面上增删改查的按钮是否显示*/
            jQuery("#list2").jqGrid('navGrid', '#pager2', {
                //设置为false需要自己重新重新该方法
                edit: false,
                add: false,
                del: false,
                search: true,
            });

        }




        //日期空间的组件
        laydate.render({
            elem: '#startLiveTime'
            ,type:'datetime'
            ,change: function(value){
                console.log(value);
                $("#startLiveTime").val(value);
            }
        });
        laydate.render({
            elem: '#endLiveTime'
            ,type:'datetime'
            ,change: function(value){
                console.log(value);
                $("#endLiveTime").val(value);
            }
        });

    });

</script>