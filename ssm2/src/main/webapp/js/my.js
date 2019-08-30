function myconfirm(title,fn){
	layer.confirm(title, {
		btn : [ '确认', '取消' ]
	}, fn);
}
function closeFrame(){
	 var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
	  parent.layer.close(index); 
}
function openFrame(url,title,area){
	if(!title) title="編輯";
	if(!area)area=['340px', '60%'];
	layer.open({
		  type: 2,
		  title: title,
		  shadeClose: true,
		  shade: 0.8,
		  area: area,
		  content: url
		}); 
}

function reload(tabid,data,startpage) {
	if(!startpage)startpage=1;
	if(!data)data={};
	layui.table.reload(tabid, {
		page : {
			curr : startpage
		},
		where : data
	}, 'data');
}

function fresh(id){
	layui.table.reload(id);
}


function getlist(url,data,selector,def_id){
		$.post(url,data, function(json) {
			var s=$(selector).empty();
			s.append($("<option value=''></option>"))
			for(var i=0;i<json.length;i++){
				var ss="";
				if(json[i].id==def_id) ss="selected='selected'";
				s.append($("<option value='"+json[i].id+"' "+ss+" >"+json[i].name+"</option>"))
			}
			layui.form.render('select');
		},"json");
}

function getarray(url,data,selector,def_index){
	$.post(url,data, function(json) {
		var s=$(selector).empty();
		s.append($("<option value=''></option>"))
		for(var i=0;i<json.length;i++){
			var ss="";
			if(i==def_index) ss="selected='selected'";
			s.append($("<option value='"+i+"' "+ss+" >"+json[i]+"</option>"))
		}
		layui.form.render('select');
	},"json");
}

function render(filter,data){
layui.form.val(filter, data);
layui.form.render();
}
