<!Doctype html>
<html>
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="css/style.css" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <title>freescholarship.com</title>
    </head>
    
<?php
$email = $_POST['email'];
$password = $_POST['pass'];

if($email == "sskanojiya165@gmail.com" && $password == "admin") {
  ?>
  <body>

  <nav class="navbar navbar-light bg-light">
  <a class="navbar-brand" href="index.html">
    <img src="image/logo.png" width="150" height="50" class="d-inline-block align-top" >
  </a>
  <div class="form-inline">
  <a href="index.html" class="btn btn-outline-danger" role="button" >Logout</a>
</div>
</nav>

    <div class = "container pt-3">
    <div class="table-responsive">
    <table class="table table-hover">
    <thead class="bg-danger">
    <tr>
      <th scope="col">Index</th>
      <th scope="col">Name</th>
      <th scope="col">Father</th>
      <th scope="col">Mobile</th>
      <th scope="col">Email</th>
      <th scope="col">Address</th>
      <th scope="col">Qualification</th>
      <th scope="col">Photo</th>
    </tr>
  </thead>
  <tbody>
<?php
$connect = mysqli_connect('localhost', 'root');
mysqli_select_db($connect, 'freescholarship');
$selectquery = "select * from scholarship_data";
$query = mysqli_query($connect, $selectquery);

while($result = mysqli_fetch_array($query)) {
    ?>
    <tr>
        <td><?php echo $result['id']?></td>
        <td><?php echo $result['name']?></td>
        <td><?php echo $result['father']?></td>
        <td><?php echo $result['mobile']?></td>
        <td><?php echo $result['email']?></td>
        <td><?php echo $result['address']?></td>
        <td><?php echo $result['qualification']?></td>
        <td><img src = "<?php echo $result['photo']; ?>" width = "100" height = "100"></td>
    </tr>
    <?php
}
?>

  </tbody>

    </table>
    </div>
</div>
    </body>
    <?php
}
else{
  header("Refresh: 0; url==mini project\login.html");
  echo '<script>alert("Ivalid Email or Password!")</script>';
}
?>
    

</html>