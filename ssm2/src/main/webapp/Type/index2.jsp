<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link href="../layui/css/layui.css" rel="stylesheet">
<script type="text/javascript" src="../layui/layui.all.js"></script>
<script src="../js/jquery-2.2.4.min.js"></script>
<script type="text/javascript" src="../js/my.js"></script>
</head>
<body>
	<table id="demo" lay-filter="test"></table>
	<script type="text/html" id="barDemo">
		<a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
		<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
	</script>
	
	<script type="text/html" id="toolbarDemo">
  		<div class="layui-btn-container">
    		<button class="layui-btn layui-btn-sm" lay-event="add">新增</button>
  		</div>
	</script>
	
	<script>
	
		layui.use('table', function() {
			var table = layui.table;

			//第一个实例
			table.render({
				elem : '#demo',
				height : 462,
				url : 'index.action' //数据接口
				,
				toolbar : '#toolbarDemo',
				page : true //开启分页
				,
				cols : [ [ //表头
				{
					field : 'id',
					title : 'ID',
					width : 80,
					sort : true,
					fixed : 'right'
				}, {
					field : 'name',
					title : '用户名',
					width : 280
				}, {
					field : 'sexname',
					title : '性别',
					width : 180
				}, {
					field : 'typename',
					title : '类型',
					width : 180
				}, {
					fixed : 'right',
					title : '操作',
					toolbar : '#barDemo',
					width : 150,
					align : 'center'
				}

				] ],
				parseData : function(res) {
					return {
						"code" : res.code,
						"msg" : res.msg,
						"count" : res.count,
						data : res.list
					}
				}
			});
			
			

			//obj 行      obj.data 行数据    data.id 列
			//test  是table的lay-filter="test" 属性
			table.on('tool(test)', function(obj) {
				var data = obj.data;
				if (obj.event === 'del') { ///lay-event 属性
					
					myconfirm("刪除？",function(){
						$.post("delete.action", {id : data.id}, 
								function(json) {
							reload('demo');
							layer.close(layer.index);
								}, "json");
					});
				}else{
					openFrame('edit.jsp?id='+data.id);
				}
			});

			table.on('toolbar(test)', function(obj) {
				if (obj.event === 'edit') {
					openFrame("edit.jsp");
				}
			});

		});
	</script>
	
</body>
</html>