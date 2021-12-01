package net.peacefulcraft.borough.storage;

import java.util.UUID;

public class BoroughChunk {

	private BoroughClaim claimMeta;
		/**
		 * @return Associated claim information or NULL of chunk is unclaimed
		 */
		public BoroughClaim getClaimMeta() { return this.claimMeta; }

	private String world;
		public String getWorld() { return this.world; }
	private int x;
		public int getChunkX() { return this.x; }
	private int y;
		public int getChunkY() { return this.y; }
	private int z;
		public int getChunkZ() { return this.z; }

	public BoroughChunk(String world, int x, int y, int z) {
		this.world = world;
		this.x = x;
		this.z = z;
	}

	public boolean isChunkClaimed() {
		return this.claimMeta != null;
	}

	public boolean canUserBuild(UUID user) {
		return (
			this.claimMeta.getBuilders().contains(user)
			|| this.claimMeta.getModerators().contains(user)
			|| this.claimMeta.getOwners().contains(user) 
		);
	}
}
