<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <meta charset="UTF-8">
    <title>게시판 등록</title>
</head>
<body>

    <table border="1" cellspacing="0" cellpadding="0" width="90%">
        <tr width="90%">
            <td width="10%" align="center">작성자</td>
            <td width="50%"><input type="text" name="createId" id="createId" style="width: 95%;" placeholder="작성자를 입력하세요."></td>
        </tr>
        <tr>
            <td align="center">제목</td>
            <td><input type="text" name="title" id="title" style="width: 95%;" placeholder="제목을 입력하세요."></td>
        </tr>
        <tr>
            <td align="center">내용</td>
            <td><textarea name="content" id="content" style="width: 95%;height: 200px;" placeholder="내용 입력하세요."></textarea></td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <button type="button" onclick=insertNotice();>등록</button>
                <button type="button" onclick=noticeListMove();>목록</button>
            </td>
        </tr>
    </table>

</body>
</html>
<script>
  // 목록이동
    function noticeListMove() {
        location.href = "/notice";
    }

    const insertNotice = () => {

        const reqData = {
            createId : document.querySelector("#createId").value,
            title : document.querySelector("#title").value,
            content : document.querySelector("#content").value
        }

        console.log(reqData);

        $.ajax({
            type: 'post',
            url: '/notice/insert',
            data: JSON.stringify(reqData),
            dataType : "json",
            contentType:"application/json",
            success: function (resData) {
                console.log(resData);
                if (resData == 1) {
                    alert("등록완료")
                }
            },
            error: function (err) {
                console.log(err);
            }
        });

    }

</script>