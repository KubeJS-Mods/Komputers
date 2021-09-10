package dev.latvian.mods.komputers.api;

import net.minecraft.core.Direction;

public class DroneAPI {
	public void park() {
		// TODO: Implement
	}

	public void unpark() {
		// TODO: Implement
	}

	public double getRotation() {
		return 0D;
	}

	public void setRotation(double r) {
		// TODO: Implement
	}

	public void setDirection(Direction direction) {
		setRotation(direction.toYRot());
	}

	public void turn(double degrees) {
		setRotation(getRotation() + degrees);
	}

	public void turnLeft() {
		turn(-90D);
	}

	public void turnRight() {
		turn(90D);
	}

	public void flyUp(double blocks) {
		// TODO: Implement
	}

	public void flyDown(double blocks) {
		flyUp(-blocks);
	}

	public void fly(double blocks) {
		// TODO: Implement
	}
}
