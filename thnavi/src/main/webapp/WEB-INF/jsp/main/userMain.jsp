<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=${mapUrl }"></script>
<link rel="stylesheet" href="https://uicdn.toast.com/grid/latest/tui-grid.css" />
<script src="https://uicdn.toast.com/grid/latest/tui-grid.js"></script>
</head>
<body>
	<h1>user</h1>
	<div id="divSearch">
		<button id="btnSearch">데이터 조회</button>
	</div>
	<div id="divMain">
		<div id="map" style="border: 1px solid blue; height:400px;"></div> <!-- 카카오 지도 -->
		<div id="grid" style="border: 1px solid black;">여긴 그리드얌</div> <!-- toast grid -->
	</div>
</body>
</html>
<script type="text/javascript">
var container = document.getElementById('map');
var options = {
	center: new kakao.maps.LatLng(37.45001879780872, 126.79300306074344),
	level: 3
};

var map = new kakao.maps.Map(container, options);

var Grid = tui.Grid;
var instance = new Grid({
	el : document.getElementById('grid'),
	columns : [
		{
			header : '이름',
			name   : 'name'
		},
		{
			header : '아티스트',
			name   : 'artist'
		}
	],
	data : [
		{
			name   : 'test',
			artist : 'qwqwqw'
		},
		{
			name   : 'test',
			artist : 'qwqwqw'
		}
	],
});

Grid.applyTheme('striped');
</script>