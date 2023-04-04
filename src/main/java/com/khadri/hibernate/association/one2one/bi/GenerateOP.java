package com.khadri.hibernate.association.one2one.bi;

import java.util.Optional;
import java.util.Random;
import java.util.function.LongFunction;
import java.util.function.LongUnaryOperator;

public class GenerateOP {

	public static void main(String[] args) {
		System.out.println(createOP());
	}

	public static Long createOP() {

		LongUnaryOperator fun1 = (op) -> {
			return op < 0 ? op * -1 : op;
		};

		LongFunction<? extends String> fun2 = (longOp) -> {

			return String.valueOf(longOp).substring(0, 4);
		};

		Optional<? extends String> optOP = new Random().longs().map(fun1)
				.mapToObj(fun2).findAny();

		return Long.valueOf(optOP.get());
	}
}
