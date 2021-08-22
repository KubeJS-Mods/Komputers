package dev.latvian.mods.komputers.data;

public class ComputerHolder<T> {
	public final long id;
	public final T holder;
	public Computer computer;

	public ComputerHolder(long i, T h) {
		id = i;
		holder = h;
		computer = null;
	}
}
