	function setCookie(key, value, days) {
		var d = new Date();
		d.setTime(d.getTime() + (1000 * 60 * 60 * 24 * days));
		var expires = "expires=" + d.toUTCString();
		document.cookie = key + "=" + value + ";" + expires + "; path=/";
	}
	function getCookieByKey(key) {
		let cookieKey = key + "=";
		let cookie = decodeURIComponent(document.cookie);
		let arr = cookie.split(";");
		for (let i = 0; i < arr.length; i++) {
			let c = arr[i].trim();
			if (c.indexOf(cookieKey) == 0) {
				return c.substring(cookieKey.length, c.length);
			}
		}
		return "";
	}
	function checkLogin() {
		var name = getCookieByKey("loginName");
		if (name != "") {
			alert("欢迎尊敬的用户 : " + name);
		} else {
			alert("-- 对不起，您需要先登录才能操作 --");
		}
	}
	function delCookie(key){
		document.cookie = key+"=''; expires=31 Dec 1990 12:00:00 UTC; path=/";
	}
	function testCode() {
		let uri = "http://127.0.0.1?loginName=jack&password=123456";
		let uri_encode = encodeURIComponent(uri);
		console.log("encode: " + uri_encode);

		let uri_decode = decodeURIComponent(uri_encode);
		console.log("decode: " + uri_decode);
	}
