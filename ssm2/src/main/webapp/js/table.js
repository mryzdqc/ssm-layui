function Etable(el,filter) {
	this.el = el;
	this.filter=filter;
	this.prop = {elem: el};
	this.init = function(url,height) {
		this.prop.url=url;
		this.prop.height=height;
		this.prop.parseData=function (res){
			  return {
				   code:res.code,
				   msg:res.msg,
				   count:res.count,
				   data:res.rows
			  };};
	}
	this.setpage=function(){
		this.prop.page=true;
	}
	this.setcols=function(colprop){
		this.prop.cols=[];
		this.prop.cols.push(colprop);
	}
	this.setrowbuttons=function(id,arr){
		var intent="";
		for(var i=0;i<arr.length;i++){
			intent+='<a class="'+arr[i].cls+'" lay-event="'+arr[i].event+'">'+arr[i].text+'</a>';
		}
		
		var s=$("<script type='text/html' id='"+id+"'></script>").html(intent);
		$("body").prepend(s);
		var p={fixed: 'right', toolbar: id, width:150,align:'center'};
		this.prop.cols[0].push(p);
	}
	this.click=null;
	this.render=function(lay){
	//	layui.use('table', function(){
			  var table = lay.table;
			  table.render(this.prop);
			  
			  table.on('tool('+filter+')', function(obj){  
			      var data = obj.data;
			      if(click!=null)click(event,data);
			  });
	//});
		}
	
}