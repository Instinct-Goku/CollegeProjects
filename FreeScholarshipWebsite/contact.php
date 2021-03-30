<?php
$connect = mysqli_connect('localhost', 'root');

mysqli_select_db($connect, 'freescholarship');

$name = $_POST['name'];
$email = $_POST['email'];
$comment = $_POST['comment'];

$query = "insert into contact(name,email,comment)
values('$name','$email', '$comment')";

mysqli_query($connect, $query);
header("Refresh: 0; url=contact.html");
echo '<script>alert("Thanks for Your feedback!")</script>';
exit;
?>