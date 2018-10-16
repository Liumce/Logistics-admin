$(function () {
	//表格分页
    $('#queryList').DataTable({
    	"scrollX"	  : true,
  		'paging'      : true,
  	    'lengthChange': true,
  	    'searching'   : true,
  	    'ordering'    : true,
  	    'info'        : true,
  	    'autoWidth'   : false,
  	  	"pagingType"  : "full_numbers",
  	  	"pageLength"  : 10
    });
    //提示框
    $("[data-toggle='tooltip']").tooltip();

    
    //展开菜单
    $(".spreadSubm").click(function(){
    	var parentId = $(this).attr("data-id");
    	var text = $(this).find("font").text();
    	var el = $(this).parent().parent();
    	if("展开" == text){
    		$(this).find("font").text("折叠");
    		$.ajax({
				type:"POST",
		        url:_ctx+"/menu/getSubMenu",
		        data:{parent_id:parentId,time:new Date().getTime()},
		        dataType:"json",
		        cache:false,
		        success: function(data){
		       	 if("success" == data.status){
					showSubMeunList(data.data,el,parentId)
		       	 }else{
					alert(data.msg);
		       	 }
		        }
			})
    	}else{
    		$(this).find("font").text("展开");
    		$(".submenu"+parentId).remove();
    	}
    });
    
    $("#submitBtn").click(function(){
    	var trafficId = $("input[name='traffic_id']").val();
    	var trafficName = $("input[name='traffic_name']").val();
    	var sendTime = $("input[name='send_time']").val();
    	var sendAddress = $("input[name='send_address']").val();
    	var trafficStatus = $("input[name='traffic_status']").val();
    	var trafficSamanId = $("[name='traffic_saman_id']").val();
    	var trafficSamanName = $("input[name='traffic_saman_name']").val();
    	var trafficSamanPhone = $("input[name='traffic_saman_phone']").val();
    	var trafficSamanCarId = $("input[name='traffic_saman_carid']").val();
    	var orderId = $("input[name='order_id']").val();
    	$.ajax({
    		type:"POST",
    		url:actionUrl,
    		data:{trafficId:traffic_id,trafficName:traffic_name,sendTime:send_time,sendAddress:send_address,trafficStatus:traffic_status,trafficSamanId:traffic_saman_id,
                trafficSamanName:traffic_saman_name,trafficSamanPhone:traffic_saman_phone,trafficSamanCarId:traffic_saman_carid,orderId:order_id},
    		dataType:"json",
    		cache:false,
    		success:function(data){
    			if(data.status == 'success'){
    				$("#queryModal").modal("hide");
    				//刷新
    				window.location.href=window.location.href;
    			}else{
    				alert(data.msg);
    			}
    		}
    	});
    	
    });
  })

