class Main inherits A2I {
$
	main() : Object {
		i : Int -> a2i( (new IO).in_string() ) ;
        ^
		if i < 10
		then (new IO).out_string("Bad Luck\n")
		else (new IO).out_string("Good Luck\n")&&

	};
%
};
