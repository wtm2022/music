var hostpath = "http://localhost:8080";
var projectName = "/music02"; // 项目路径
var dataPath; // 数据请求地址
var op;

$(document).click(function (e) {
	let obj = e.target;
	if (obj.innerText == '每日推荐') {
		showRight();
		dataPath = "/getAllMusics";
		op = 1;
		getData(op, hostpath + projectName + dataPath);
	} else if (obj.innerText == '所有歌手') {
		showRight();
		op = 2
		getData(op, hostpath + "/skeyedu-music/getAllSingers");
	} else if (obj.innerText == '歌单') {
		showRight();
		// 歌单还没有...
	} else if (obj.innerText == '排行榜') {
		showRight();
		getData(4, hostpath + "/skeyedu-music/getMussicByChart");
	}
})

function showRight() {
	$(".container-show").slideDown();
}

function getData(op, path) {
	$.ajax({
		url: path,
		type: "get",
		dataType: "json",
		success: function (result) {
			console.log(result);
			if (result.status==200) {
				if (op == 1) {
					showMusic(result);
				} else if (op == 2) {

				} else if (op == 3) {

				} else if (op == 4) {

				}
			} else {
				alert(result.msg);
			}
		}
	})
}
// 显示音乐数据
function showMusic(result) {
	// console.log("---music---");
	$("#info tr").remove();
	let t = $("#info")[0];
	t.insertRow().innerHTML = `
				<td>歌曲编号</td>
				<td>歌曲名称</td>
				<td>点播统计</td>
				<td>操作选项</td>
			`;

	let arr = result.data;
	for (let m of arr) {
		row = t.insertRow();
		row.insertCell().innerHTML = m.music_id;
		row.insertCell().innerHTML = m.music_name;
		row.insertCell().innerHTML = m.play_count;
		row.insertCell().innerHTML = `<a class='glyphicon glyphicon-play-circle' onclick = "playMusic('${hostpath}${projectName}${m.music_url}')"></a>`
	}

	t.insertRow().innerHTML = `
			<td colspan="4">
				<div class="form-inline">
				<a class="page-btn fl" onclick="getData( ${op}, '${hostpath+dataPath}' , ${result.upPage} , ${result.pageSize} )" >上一页</a>
				总1页
				<select class="form-control" style="size:1" name='currentPage'>
				  <option>1</option>
				</select>
				<a class="page-btn fr" onclick="getData( ${op}, '${hostpath+dataPath}' , ${result.nextPage} , ${result.pageSize} )" >下一页</a>
				</div>
			</td> `;
}

// 退出登录
function loginOut() {
	delCookie("loginName");
	location.href = "index.html";
}