<%@page import="com.qdu.pojo.Page"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon" href="static/images/favicon.ico" />
<!-- Bootstrap -->
<link href="static/bootstrap-3.3.7-dist/css/bootstrap.min.css"
	rel="stylesheet">
<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script src="static/js/jquery-1.11.0.min.js"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<!-- 引入分页插件 -->
<link rel="stylesheet" href="static/jsPage/jquery.sPage.css"></link>
<link rel="stylesheet" href="static/jsPage/jquery.sPage.green.css"></link>
<script type="text/javascript" src="static/jsPage/jquery.sPage.js"></script>

<title>查询所有</title>
</head>
<body>
	<!-- 员工修改的模态框 -->
	<!-- Modal -->
	<div class="modal fade" id="empUpdateModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">员工信息修改</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" id="deleteForm">
						<input type="hidden" class="form-control" id="update_id"
							name="empID" placeholder="xxx@163.com" hidden>
						<div class="form-group">
							<label for="inputEmpName" class="col-sm-2 control-label">姓名</label>
							<div class="col-sm-10">
								<input type="hidden" class="form-control" id="update_name"
									name="empName" placeholder="xxx@163.com" hidden>
								<p class="form-control-static" id="empName_update_static"></p>
							</div>
						</div>
						<div class="form-group">
							<label for="inputEmail" class="col-sm-2 control-label">邮箱</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="email_update_input"
									name="email" placeholder="xxx@163.com"> <span
									class="help-block"></span>
							</div>
						</div>
						<div class="form-group">
							<label for="inputGender" name="gender"
								class="col-sm-2 control-label">性别</label>
							<div class="col-sm-10">
								<label class="radio-inline"> <input type="radio"
									name="gender" id="gender1_update_input" value="M"> 男
								</label> <label class="radio-inline"> <input type="radio"
									name="gender" id="gender2_update_input" value="F"> 女
								</label>
							</div>
						</div>
						<div class="form-group">
							<label for="inputdept" class="col-sm-2 control-label">部门</label>
							<div class="col-sm-4">
								<select class="form-control" name="dept" id="dept_update_area">
								</select>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					<button type="button" class="btn btn-primary" id="emp_update_btn">保存</button>
				</div>
			</div>
		</div>
	</div>
	<!-- 新增员工的模态框 -->
	<!-- Modal -->
	<div class="modal fade" id="empAddModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">添加员工</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" id="insetForm">
						<div class="form-group">
							<label for="inputEmpName" class="col-sm-2 control-label">姓名</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="empName_add_input"
									name="empName" placeholder="张三"> <span
									class="help-block"></span>
							</div>
						</div>
						<div class="form-group">
							<label for="inputEmail" class="col-sm-2 control-label">邮箱</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="email_add_input"
									name="email" placeholder="xxx@163.com"> <span
									class="help-block"></span>
							</div>
						</div>
						<div class="form-group">
							<label for="inputGender" name="gender"
								class="col-sm-2 control-label">性别</label>
							<div class="col-sm-10">
								<label class="radio-inline"> <input type="radio"
									name="gender" id="gender1_add_input" value="M"
									checked="checked"> 男
								</label> <label class="radio-inline"> <input type="radio"
									name="gender" id="gender2_add_input" value="F"> 女
								</label>
							</div>
						</div>
						<div class="form-group">
							<label for="inputdept" class="col-sm-2 control-label">部门</label>
							<div class="col-sm-4">
								<select class="form-control" name="dId" id="dept_add_area">
								</select>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					<button type="button" class="btn btn-primary" id="emp_save_btn">保存</button>
				</div>
			</div>
		</div>
	</div>
	<!-- 搭建显示页面 -->
	<div class="container">
		<!-- 标题 -->
		<div class="row">
			<div class="col-md-12">
				<h1>员工信息管理系统</h1>
			</div>
		</div>
		<!-- 新增 删除 按钮 -->
		<div class="row">
			<div class="col-md-4 col-md-offset-8">
				<button type="button" class="btn btn-primary" id="emp_add_modal_btn">新增</button>
				<button type="button" class="btn btn-danger" onclick="getAllEmp()">查询所有</button>
			</div>
		</div>
		<!-- 显示表格数据 -->
		<div class="row">
			<div class="col-md-12">
				<table class="table table-bordered table-hover" id="tb_emp">
					<thead>
						<tr>
							<th>ID</th>
							<th>empname</th>
							<th>gender</th>
							<th>email</th>
							<th>deptName</th>
							<th>操作</th>
						</tr>
					</thead>
					<!-- 这是一个假的数据 -->
					<tbody>
						<tr>
							<th>1</th>
							<th>张三</th>
							<th>男</th>
							<th>123456@qq.com</th>
							<th>研发部</th>
							<th><button type="button" class="btn btn-primary btn-sm">
									修改 <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
								</button>
								<button type="button" class="btn btn-danger btn-sm"
									id="deleteEmp">
									删除 <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
								</button></th>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<!-- 显示分页信息 -->
		<div class="row" id="myPage"></div>
	</div>
	<script type="text/javascript">
		function getAllEmp(pageDisplay) {
			//第一页
			if (pageDisplay == undefined)
				pageDisplay = 0;

			$
					.ajax({
						url : "queryAllStudent",
						type : "GET",
						data : {
							"strPage" : pageDisplay
						},

						success : function(data) {
							console.log(typeof data);
							console.log("请求发送成功");
							conn = "<tr>";
							$(data.list)
									.each(
											function() {
												var sex;
												if (this.gender == "M")
													sex = "男";
												else
													sex = "女";
												conn += "<th>"
														+ this.emp_id
														+ "</th><th>"
														+ this.emp_name
														+ "</th><th>"
														+ sex
														+ "</th><th>"
														+ this.email
														+ "</th><th>"
														+ this.dept
														+ "</th><th><button type='button' class='btn btn-primary btn-sm' id='updateEmp'>修改 <span class='glyphicon glyphicon-pencil' aria-hidden='true'></span></button><button type='button' class='btn btn-danger btn-sm' id='deleteEmp'>"
														+ "删除 <span class='glyphicon glyphicon-remove' aria-hidden='true'></span></button></th></tr>"
											});
							$("#tb_emp tbody").empty();
							$("#tb_emp").append(conn);
							$("#myPage").sPage({
								page : data.page,//当前页码，必填
								total : data.totals,//数据总条数，必填
								pageSize : 10,//每页显示多少条数据，默认10条
								totalTxt : "共{" + data.totalPages + "}条",//数据总条数文字描述，{total}为占位符，默认"共{total}条"
								showTotal : true,//是否显示总条数，默认关闭：false
								showSkip : true,//是否显示跳页，默认关闭：false
								showPN : true,//是否显示上下翻页，默认开启：true
								prevPage : "上一页",//上翻页文字描述，默认“上一页”
								nextPage : "下一页",//下翻页文字描述，默认“下一页”
								backFun : function(page) {
									//点击分页按钮回调函数，返回当前页码
									console.log(page);
								}
							});
						}
					})
		}

		function reset_form(ele) {
			$(ele)[0].reset();
			$(ele).find("*").removeClass("has-error has-success");
			$(ele).find(".help-block").text("");
		}

		$("#emp_add_modal_btn").click(function() {
			//清除表单数据和样式
			reset_form("#empAddModal form")
			//发送ajax请求，查出部门信息，显示在下拉列表中
			getDepts("#dept_add_area");
			//弹出新增模态框
			$("#empAddModal").modal({
				backdrop : "static"
			});
		});

		//查出所有部门名称
		function getDepts(ele) {
			$(ele).empty();
			$.ajax({
				url : "deptServlet",
				type : "GET",
				success : function(result) {
					//{"code":100,"msg":"处理成功","extend":{"depts":[{"deptId":1,"deptName":"开发部"},{"deptId":2,"deptName":"测试部"},{"deptId":3,"deptName":"财务部"},{"deptId":4,"deptName":"秘书部"},{"deptId":5,"deptName":"后勤部"},{"deptId":6,"deptName":"总务处"}]}}
					/* console.log('部门请求成功'); */
					//提取部门信息显示在下拉列表中
					var deptInfo = result;
					$.each(deptInfo, function(index, item) {
						var option = $("<option></option>").append(
								item.dept_name).attr("value", item.dept_name);
						option.appendTo(ele);
					});
				}
			});
		}

		/* 保存新增员工信息 */
		$("#emp_save_btn").click(function() {
			$.ajax({
				url : "insertServlet",
				type : "post",
				data : $("#insetForm").serialize(),
				success : function(msg) {
					alert(msg);
				}

			});
			$("#empAddModal").modal("hide");
		});

		/* 删除单个员工 */
		$(document)
				.on(
						"click",
						"#deleteEmp",
						function() {
							var empName = $(this).parents("tr")
									.find("th:eq(1)").text();
							var currentPage = $(".spage-number")
									.find(".active").text();
							if (confirm("确认删除" + empName + "?")) {
								$.ajax({
									url : "deleteServlet",
									type : "post",
									data : {
										"userID" : $(this).parents("tr").find(
												"th:eq(0)").text()
									},
									success : function(msg) {
										alert(msg);
										getAllEmp(currentPage);
									}
								});
							}
						});
		/*更新员工*/
		$(document).on("click", "#updateEmp", function() {
			//查出部门信息
			getDepts("#dept_update_area");
			//查出员工信息
			var empID = $(this).parents("tr").find("th:eq(0)").text();
			getEmp(empID);

			//弹出框,把员工ID传递给更新按钮
			//$("#emp_update_btn").attr("edit-id", $(this).attr("edit-id"));
			$("#empUpdateModal").modal({
				backdrop : "static"
			});

		});

		//获取单个员工信息
		function getEmp(empID) {
			/* alert(empID); */
			console.log("即将要查询的员工：" + empID);
			$.ajax({
				url : "getEmpByID",
				/* url : "insertServlet", */
				type : "get",
				data : {
					"empID" : empID
				},
				success : function(data) {
					console.log(typeof data);
					$("#update_name").val([data.emp_name]);
					$("#update_id").val([ data.emp_id ]);
					$("#empName_update_static").text(data.emp_name);
					$("#email_update_input").val(data.email);
					//type=radio
					$("#empUpdateModal input[name=gender]")
							.val([ data.gender ]);
					$("#empUpdateModal select").val([ data.dept ]);
				}
			});
		}

		//保存要更新的员工信息
		$(document).on("click", "#emp_update_btn", function() {
			var currentPage = $(".spage-number").find(".active").text();
			$.ajax({
				url : "updateServlet",
				type : "post",
				data : $("#deleteForm").serialize(),
				success : function() {
					//关闭模态框
					$("#empUpdateModal").modal("hide");
					//回到本页面
					getAllEmp(currentPage);
				}

			});

		});
	</script>
</body>
</html>