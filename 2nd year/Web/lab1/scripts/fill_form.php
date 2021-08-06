<html>
<head>
    <title>Lab 1</title>
    <link rel="stylesheet" href="../styles/form_page.css">
</head>
<body>
<?php
session_start();
$attempts = (isset ($_SESSION["attempts"])) ? ($_SESSION["attempts"]) : array();
header('Content-type: application/json');

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    try {
        $coords = new Coordinates();
        $current_attempt = new Attempt($coords);
        array_push($attempts, $current_attempt);
        $_SESSION["attempts"] = $attempts;
        echo json_encode($attempts);
//        echo "<br>";
//        print_r($attempts);


        echo "<br><br>Last attempt: X:".$current_attempt->get_coordinates()->get_x()."\n Y:".$current_attempt->get_coordinates()->
            get_y()."\n R:".$current_attempt->get_coordinates()->get_r()."\n result:".$current_attempt->
            get_result()."\n time:".$current_attempt->get_time()."\n scriptTime:".$current_attempt->get_script_time()."ms";
    } catch (Exception $e) {
        echo json_encode($e->getMessage());
//        echo $e->getMessage();
    }
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


class Coordinates
{
    private $x;
    private $y;
    private $r;

    public function __construct()
    {
        if (empty($_POST["x"])) {
            throw new Exception('X coordinate is empty');
        } else {
            $this->x = (int)($_POST["x"]);
            if ($this->x > 4 or $this->x < -4) {
                throw new Exception("X coordinate isn't in -4..4");
            }
        }

        if (empty($_POST["y"])) {
            throw new Exception('Y coordinate is empty');
        } else {
            $this->y = (double)($_POST["y"]);
            if ($this->y > 3 or $this->y < -5) {
                throw new Exception("Y coordinate isn't in -5..3");
            }
        }

        if (empty($_POST["r"])) {
            throw new Exception('R is empty');
        } else {
            $this->r = (double)$_POST["r"];
            if ($this->r > 5 or $this->r < 2) {
                throw new Exception("R isn't in -2..5");
            }
        }

    }

    public function get_x()
    {
        return $this->x;
    }

    public function get_y()
    {
        return $this->y;
    }

    public function get_r()
    {
        return $this->r;
    }
}

class Attempt
{
    private $coordinates;
    private $result;
    private $time;
    private $script_time;

    public function get_coordinates()
    {
        return $this->coordinates;
    }

    public function get_result()
    {
        return $this->result;
    }

    public function get_time()
    {
        return $this->time;
    }

    public function get_script_time()
    {
        return $this->script_time;
    }

    public function __construct($input_coordinates)
    {
        $this->coordinates = $input_coordinates;

        $start_time = microtime(true);
        $x = $this->coordinates->get_x();
        $y = $this->coordinates->get_y();
        $r = $this->coordinates->get_r();
        if (($x <= 0 and $y <= 0 and ($x ^ 2 + $y ^ 2 <= ($r / 2) ^ 2))
            or ($x >= 0 and $x <= $r / 2 and $y <= 0 and $y >= -$r)
            or ($x + $r / 2 >= $y and $y >= 0 and $x >= 0)) {
            $this->result = true;
        } else {
            $this->result = false;
        }
        $this->script_time = microtime(true) - $start_time;
        $this->time = date("H:i:s");
    }
}
?>
</body>
</html>