<html>
	<head>
		<title>Lab 1</title>
		<link rel="stylesheet" href="../styles/form_page.css">
	</head>
	<body>
		<b>Входные данные:</b>  
		х = <?php echo (int)($_POST['x']); ?>;
		y = <?php echo (double)$_POST['y']; ?>; 
		R = <?php echo (double)$_POST['r']; ?> <br>
		
		<img src="../images/web_lab1.jpg"> <br>
		<?php
		$start_time = microtime(true);
			$y = $r = $x = "";
			$x_error = $y_error = $r_error = 0;

			if ($_SERVER["REQUEST_METHOD"] == "POST") {
				
				if (empty($_POST["x"])) {
					$x_error = "Вы забыли написать координату X <br>";
				} else {
					$x = (int)($_POST["x"]);
					if (x > 4 or x <-4) {
						$x_error = "Координата x должна быть в диапозоне -4..4 <br>";
					}
				}
				
				if (empty($_POST["y"])) {
					$y_error = "Вы забыли написать координату Y <br>";
				} else {
					$y = (double)($_POST["y"]);
					if ($y > 3 or $y < -5) {
						$y_error = "Координата y должна быть в диапозоне -5..3 <br>";
					}
				}
				
				if (empty($_POST["r"])) {
					$r_error = "Вы забыли написать значение R <br>";
				}else{
					$r = (double) $_POST["r"];
					if ($r > 5 or $r < 2) {
						$r_error = "Значение R должно быть в диапозоне 2..5 <br>";
					}
				}
			}
			if ($x_error == 0 and y_error == 0 and r_error == 0){
				echo "Данные валидны <br>";			
				
				echo "<br>";
				if (($x <= 0 and $y <= 0 and ($x^2 + $y^2 <=($r/2)^2)) or ($x >=0 and $x <= $r/2 and $y <= 0 and $y >= -$r) or ($x + $r/2 >= $y and $y>= 0 and $x >= 0)){
					echo "<b>yes</b>";
					$point_result = "true";
				}else{
					echo "<b>no</b>";
					$point_result = "false";
				}
				
			}else{
				echo "x:'$x_error'<br>y:'$y_error'<br>r:'$r_error'";
			}
			
			function array_to_table($header_table, $table){
				echo "<table>\n";
				//header
				foreach ($header_table as $header) {
				  echo "<th>".$header."</th>";
				}
				while ($line = pg_fetch_array($table, null, PGSQL_ASSOC)) {
					echo "\t<tr>\n";
					foreach ($line as $col_value) {
						echo "\t\t<td>$col_value</td>\n";
					}
					echo "\t</tr>\n";
				}
				echo "</table>\n";
			}
			
			$head_arr = array("id", "X", "Y", "R", "result", "time", "script time");
		
			$properties_file_path = "./../data/db_properties.txt";
			$conn_string = file_get_contents($properties_file_path);
			$db_connection = pg_connect($conn_string);
			if ($db_connection) {
				//echo '<br>Connection attempt succeeded.';
				$script_time = microtime(true) - $start_time;
				$current_time = date("H:i:s");
				$x =(float)$x;
				//echo "<br> $x, $y, $r, $point_result, $current_time, $script_time";
				
				$send_new_point_result = pg_query($db_connection, "INSERT INTO webLab1(x, y, r, result, time, scriptTime)\n VALUES ($x, $y, $r, $point_result, '$current_time', $script_time)");
				if(!$send_new_point_result){
					echo"<br>";
					echo pg_last_error($db_connection);
				}
				$get_full_table_result = pg_query($db_connection, "SELECT * FROM webLab1");
				if(!$get_full_table_result){
					echo "<br> pg_last_error($db_connection)";
				}
				array_to_table($head_arr, $get_full_table_result);
			} else {
				echo 'Connection attempt failed.';
			}
			pg_close($db_connection);
		?>
	</body>
</html>

