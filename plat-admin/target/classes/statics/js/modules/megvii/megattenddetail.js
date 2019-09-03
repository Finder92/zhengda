$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'megvii/megattenddetail/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true,align:'center' },
			{ label: '公司ID', name: 'companyId', index: 'company_id', width: 80,align:'center' },
			{ label: '公司名称', name: 'companyName', index: 'company_name', width: 80,align:'center' },
			{ label: '部门ID', name: 'deptId', index: 'dept_id', width: 80,align:'center' },
			{ label: '部门名称', name: 'deptName', index: 'dept_name', width: 80,align:'center' },
			{ label: '员工ID', name: 'empId', index: 'emp_id', width: 80,align:'center' },
			{ label: '员工姓名', name: 'empName', index: 'emp_name', width: 80,align:'center' },
			{ label: '日期', name: 'date', index: 'date', width: 80,align:'center' },
			{ label: '视频识别时间', name: 'videoTime', index: 'video_time', width: 80,align:'center' },
			{ label: '监控地点', name: 'place', index: 'place', width: 80,align:'center' },
			{ label: '照片', name: 'photo', index: 'photo', width: 80,align:'center' },
			{ label: '视频', name: 'video', index: 'video', width: 80,align:'center' }
        ],
		viewrecords: true,
        height: 385,
        rowNum: 10,
		rowList : [10,30,50],
        rownumbers: true, 
        rownumWidth: 25, 
        autowidth:true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader : {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames : {
            page:"page", 
            rows:"limit", 
            order: "order"
        },
        gridComplete:function(){
        	//隐藏grid底部滚动条
        	$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" }); 
        }
    });
});

var vm = new Vue({
	el:'#rrapp',
	data:{
		showList: true,
		title: null,
		megAttendDetail: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.megAttendDetail = {};
		},
		update: function (event) {
			var id = getSelectedRow();
			if(id == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(id)
		},
		saveOrUpdate: function (event) {
		    $('#btnSaveOrUpdate').button('loading').delay(1000).queue(function() {
                var url = vm.megAttendDetail.id == null ? "megvii/megattenddetail/save" : "megvii/megattenddetail/update";
                $.ajax({
                    type: "POST",
                    url: baseURL + url,
                    contentType: "application/json",
                    data: JSON.stringify(vm.megAttendDetail),
                    success: function(r){
                        if(r.code === 0){
                             layer.msg("操作成功", {icon: 1});
                             vm.reload();
                             $('#btnSaveOrUpdate').button('reset');
                             $('#btnSaveOrUpdate').dequeue();
                        }else{
                            layer.alert(r.msg);
                            $('#btnSaveOrUpdate').button('reset');
                            $('#btnSaveOrUpdate').dequeue();
                        }
                    }
                });
			});
		},
		del: function (event) {
			var ids = getSelectedRows();
			if(ids == null){
				return ;
			}
			var lock = false;
            layer.confirm('确定要删除选中的记录？', {
                btn: ['确定','取消'] //按钮
            }, function(){
               if(!lock) {
                    lock = true;
		            $.ajax({
                        type: "POST",
                        url: baseURL + "megvii/megattenddetail/delete",
                        contentType: "application/json",
                        data: JSON.stringify(ids),
                        success: function(r){
                            if(r.code == 0){
                                layer.msg("操作成功", {icon: 1});
                                $("#jqGrid").trigger("reloadGrid");
                            }else{
                                layer.alert(r.msg);
                            }
                        }
				    });
			    }
             }, function(){
             });
		},
		getInfo: function(id){
			$.get(baseURL + "megvii/megattenddetail/info/"+id, function(r){
                vm.megAttendDetail = r.megAttendDetail;
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                page:page
            }).trigger("reloadGrid");
		}
	}
});