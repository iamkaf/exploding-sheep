import { Capability, Readiness, describe, expect, test } from "@teakit/test";

describe.configure({
  timeout: "6m",
  readiness: [Readiness.ClientReady, Readiness.IntegratedServerReady, Readiness.PlayerSpawned],
  capabilities: [
    Capability.RuntimeTiming,
    Capability.ServerCommands,
    Capability.WorldBlock,
    Capability.WorldFill,
    Capability.WorldSetBlock,
  ],
});

describe("Exploding Sheep", () => {
  test("keeps the run healthy around grass-eating sheep", async ({ commands, runtime, world }) => {
    await commands.run("/gamemode creative");
    await commands.run("/difficulty peaceful");
    await commands.run("/gamerule mobGriefing false");
    await commands.run("/kill @e[type=minecraft:sheep,distance=..16]");
    await commands.run("/kill @e[type=minecraft:item,distance=..16]");
    await commands.run("/tp @s 0.5 80 0.5 0 20");

    await world.clear({ x: -6, y: 79, z: -6 }, { x: 6, y: 84, z: 6 });
    await world.fill({ x: -4, y: 79, z: -4 }, { x: 4, y: 79, z: 4 }, "minecraft:grass_block");
    await world.setBlock({ x: 0, y: 80, z: 2 }, "minecraft:grass");

    await commands.assert("/summon minecraft:sheep 0 80 2 {NoAI:0b}");
    await commands.assert("/execute if entity @e[type=minecraft:sheep,distance=..8]");
    await runtime.wait(2_000, { timeoutMs: 4_000 });
    await commands.assert("/execute if entity @s");

    await expect(() => world.block({ x: 0, y: 79, z: 0 })).toEventuallyEqual(
      expect.objectContaining({ id: "minecraft:grass_block" }),
      { timeout: "3s" },
    );
  });
});
