package com.yoti.tech.task.hoover.rest;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yoti.tech.task.hoover.rest.validation.CoordConstraint;
import com.yoti.tech.task.hoover.rest.validation.PatchesConstraint;
import com.yoti.tech.task.hoover.rest.validation.RoomSizeConstraint;

@JsonIgnoreProperties(ignoreUnknown = true)

public class Request {

	@JsonProperty("roomSize")
	@RoomSizeConstraint // Custom validation
	private final int[] roomSize;

	@JsonProperty("coords")
	@CoordConstraint // Custom validation
	private final int[] coords;

	@JsonProperty("patches")
	@PatchesConstraint // Custom validation
	private final int[][] patches;

	@JsonProperty("instructions")
	@NotNull(message = "Instructions must be provided")
	@Size(min = 1, message = "One or more instructions must be provided")
	@Pattern(regexp = "[NESW]+", message = "Instructions can only be one of the following: N, E, S, W")
	private String instructions;

	/**
	 * 
	 * @param patches
	 * @param coords
	 * @param instructions
	 * @param roomSize
	 */

	public Request(@JsonProperty("roomSize") int[] roomSize, @JsonProperty("coords") int[] coords,
			@JsonProperty("patches") int[][] patches, @JsonProperty("instructions") String instructions) {
		super();
		this.roomSize = roomSize;
		this.coords = coords;
		this.patches = patches;
		this.instructions = instructions;
	}

	public int[] getRoomSize() {
		return roomSize;
	}

	public int[][] getPatches() {
		return patches;
	}

	public String getInstructions() {
		return instructions;
	}

	public int[] getCoords() {
		return coords;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("roomSize", roomSize).append("coords", coords)
				.append("patches", patches).append("instructions", instructions).toString();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(patches).append(coords).append(instructions).append(roomSize).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof Request) == false) {
			return false;
		}
		Request rhs = ((Request) other);
		return new EqualsBuilder().append(patches, rhs.patches).append(coords, rhs.coords)
				.append(instructions, rhs.instructions).append(roomSize, rhs.roomSize).isEquals();
	}

}