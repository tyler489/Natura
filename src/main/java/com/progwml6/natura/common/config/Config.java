package com.progwml6.natura.common.config;

import org.apache.logging.log4j.Logger;

import com.progwml6.natura.library.Util;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import slimeknights.mantle.pulsar.config.ForgeCFG;

public final class Config
{
    public static ForgeCFG pulseConfig = new ForgeCFG("NaturaModules", "Modules");

    public static Config instance = new Config();

    public static Logger log = Util.getLogger("Config");

    private static final String ENABLE_DISABLE = "ENABLE-DISABLE";

    private static final String WORLDGEN = "Worldgen";

    private Config()
    {
    }

    public static void load(FMLPreInitializationEvent event)
    {
        configFile = new Configuration(event.getSuggestedConfigurationFile(), "0.2", false);
        configFile.load();

        syncConfig();
    }

    public static boolean syncConfig()
    {
        enableRetrogen = configFile.get("Retrogen", "Retroactive Generation", enableRetrogen).getBoolean(enableRetrogen);

        boolean BoP = false;
        if (Loader.isModLoaded("BiomesOPlenty"))
        {
            BoP = true;
        }

        babyHeatscarMinimum = configFile.get("Mob Changes", "Minimum Baby Heatscar Spiders on Spider Death", babyHeatscarMinimum).getInt(babyHeatscarMinimum);
        if (babyHeatscarMinimum < 0)
        {
            babyHeatscarMinimum = 0;
        }

        babyHeatscarMaximum = configFile.get("Mob Changes", "Maximum Baby Heatscar Spiders on Spider Death", babyHeatscarMaximum).getInt(babyHeatscarMaximum);
        if (babyHeatscarMaximum < 0)
        {
            babyHeatscarMaximum = 0;
        }

        overrideNether = configFile.get(ENABLE_DISABLE, "Override Nether", !BoP).getBoolean(!BoP);
        canRespawnInNether = configFile.get(ENABLE_DISABLE, "Obelisks let players respawn in the Nether", canRespawnInNether).getBoolean(canRespawnInNether);

        // Trees Start
        generateRedwood = configFile.get(ENABLE_DISABLE, "Generate Redwood Trees", generateRedwood).getBoolean(generateRedwood);

        generateMaple = configFile.get(ENABLE_DISABLE, "Generate Maple Trees", generateMaple).getBoolean(generateMaple);
        generateSilverbell = configFile.get(ENABLE_DISABLE, "Generate Silverbell Trees", generateSilverbell).getBoolean(generateSilverbell);
        generateAmaranth = configFile.get(ENABLE_DISABLE, "Generate Amaranth Trees", generateAmaranth).getBoolean(generateAmaranth);
        generateTiger = configFile.get(ENABLE_DISABLE, "Generate Tigerwood Trees", generateTiger).getBoolean(generateTiger);

        generateWillow = configFile.get(ENABLE_DISABLE, "Generate Willow Trees", generateWillow).getBoolean(generateWillow);
        generateEucalyptus = configFile.get(ENABLE_DISABLE, "Generate Small Eucalyptus Trees", generateEucalyptus).getBoolean(generateEucalyptus);
        generateHopseed = configFile.get(ENABLE_DISABLE, "Generate Hopseed Trees", generateHopseed).getBoolean(generateHopseed);
        generateSakura = configFile.get(ENABLE_DISABLE, "Generate Sakura Trees", generateSakura).getBoolean(generateSakura);

        generateSaguaro = configFile.get(ENABLE_DISABLE, "Generate Saguaro Cactus", generateSaguaro).getBoolean(generateSaguaro);

        generateBloodwood = configFile.get(ENABLE_DISABLE, "Generate Bloodwood Trees", generateBloodwood).getBoolean(generateBloodwood);
        generateDarkwood = configFile.get(ENABLE_DISABLE, "Generate Darkwood Trees", generateDarkwood).getBoolean(generateDarkwood);
        generateFusewood = configFile.get(ENABLE_DISABLE, "Generate Fusewood Trees", generateFusewood).getBoolean(generateFusewood);
        generateGhostwood = configFile.get(ENABLE_DISABLE, "Generate Ghostwood Trees", generateGhostwood).getBoolean(generateGhostwood);
        // Trees End

        generateThornvines = configFile.get(ENABLE_DISABLE, "Generate Thornvines", generateThornvines).getBoolean(generateThornvines);

        generateBarley = configFile.get(ENABLE_DISABLE, "Generate Barley Crops", generateBarley).getBoolean(generateBarley);
        generateCotton = configFile.get(ENABLE_DISABLE, "Generate Cotton Crops", generateCotton).getBoolean(generateCotton);
        generateBluebells = configFile.get(ENABLE_DISABLE, "Generate Bluebell Flowers", generateBluebells).getBoolean(generateBluebells);

        generateBlueberries = configFile.get(ENABLE_DISABLE, "Generate Blueberry Bushes", generateBlueberries).getBoolean(generateBlueberries);
        generateBlackberries = configFile.get(ENABLE_DISABLE, "Generate Blackberry Bushes", generateBlackberries).getBoolean(generateBlackberries);
        generateRaspberries = configFile.get(ENABLE_DISABLE, "Generate Raspberry Bushes", generateRaspberries).getBoolean(generateRaspberries);
        generateMaloberries = configFile.get(ENABLE_DISABLE, "Generate Maloberry Bushes", generateMaloberries).getBoolean(generateMaloberries);

        generateBlightberries = configFile.get(ENABLE_DISABLE, "Generate Blightberry Bushes", generateBlightberries).getBoolean(generateBlightberries);
        generateDuskberries = configFile.get(ENABLE_DISABLE, "Generate Duskberry Bushes", generateDuskberries).getBoolean(generateDuskberries);
        generateSkyberries = configFile.get(ENABLE_DISABLE, "Generate Skyberry Bushes", generateSkyberries).getBoolean(generateSkyberries);
        generateStingberries = configFile.get(ENABLE_DISABLE, "Generate Stingberry Bushes", generateStingberries).getBoolean(generateStingberries);

        generateGreenglowshroom = configFile.get(ENABLE_DISABLE, "Generate Green Glowshroom", generateGreenglowshroom).getBoolean(generateGreenglowshroom);
        generatePurpleglowshroom = configFile.get(ENABLE_DISABLE, "Generate Purple Glowshroom", generatePurpleglowshroom).getBoolean(generatePurpleglowshroom);
        generateBlueglowshroom = configFile.get(ENABLE_DISABLE, "Generate Blue Glowshroom", generateBlueglowshroom).getBoolean(generateBlueglowshroom);
        generateGlowshroomtree = configFile.get(ENABLE_DISABLE, "Generate Glowshroom Trees", generateGlowshroomtree).getBoolean(generateGlowshroomtree);
        dropCotton = configFile.get(ENABLE_DISABLE, "Drop cotton seeds from grass", dropCotton).getBoolean(dropCotton);
        dropBarley = configFile.get(ENABLE_DISABLE, "Drop barley seeds from grass", dropBarley).getBoolean(dropBarley);
        try
        {
            Class.forName("chococraft.common.ModChocoCraft");
            enableWheatRecipe = configFile.get(ENABLE_DISABLE, "Enable wheat to flour recipe", false).getBoolean(false);
        }
        catch (Exception e)
        {
            enableWheatRecipe = configFile.get(ENABLE_DISABLE, "Enable wheat to flour recipe", true).getBoolean(true);
        }

        // Trees Start
        redwoodSpawnRarity = configFile.get(WORLDGEN, "Redwood Tree Spawn Rarity", redwoodSpawnRarity).getInt(redwoodSpawnRarity);

        mapleRarity = configFile.get(WORLDGEN, "Maple Tree Spawn Rarity", mapleRarity).getInt(mapleRarity);
        silverbellRarity = configFile.get(WORLDGEN, "Silverbell Tree Spawn Rarity", silverbellRarity).getInt(silverbellRarity);
        amaranthRarity = configFile.get(WORLDGEN, "Amaranth Tree Spawn Rarity", amaranthRarity).getInt(amaranthRarity);
        tigerRarity = configFile.get(WORLDGEN, "Tigerwood Tree Spawn Rarity", tigerRarity).getInt(tigerRarity);

        willowRarity = configFile.get(WORLDGEN, "Willow Tree Spawn Rarity", willowRarity).getInt(willowRarity);
        eucalyptusSpawnRarity = configFile.get(WORLDGEN, "Eucalyptus Tree Spawn Rarity", eucalyptusSpawnRarity).getInt(eucalyptusSpawnRarity);
        eucalyptusSpawnRange = configFile.get(WORLDGEN, "Eucalyptus Tree Spawn Range", eucalyptusSpawnRange).getInt(eucalyptusSpawnRange);
        hopseedSpawnRarity = configFile.get(WORLDGEN, "Hopseed Tree Spawn Rarity", hopseedSpawnRarity).getInt(hopseedSpawnRarity);
        hopseedSpawnRange = configFile.get(WORLDGEN, "Hopseed Tree Spawn Range", hopseedSpawnRange).getInt(hopseedSpawnRange);
        sakuraSpawnRarity = configFile.get(WORLDGEN, "Sakura Tree Spawn Rarity", sakuraSpawnRarity).getInt(sakuraSpawnRarity);
        sakuraSpawnRange = configFile.get(WORLDGEN, "Sakura Tree Spawn Range", sakuraSpawnRange).getInt(sakuraSpawnRange);

        bloodwoodSpawnRarity = configFile.get(WORLDGEN, "Bloodwood Tree Spawn Rarity", bloodwoodSpawnRarity).getInt(bloodwoodSpawnRarity);
        darkwoodSpawnRarity = configFile.get(WORLDGEN, "Darkwood Tree Spawn Rarity", darkwoodSpawnRarity).getInt(darkwoodSpawnRarity);
        fusewoodSpawnRarity = configFile.get(WORLDGEN, "Fusewood Tree Spawn Rarity", fusewoodSpawnRarity).getInt(fusewoodSpawnRarity);
        ghostwoodSpawnRarity = configFile.get(WORLDGEN, "Ghostwood Tree Spawn Rarity", ghostwoodSpawnRarity).getInt(ghostwoodSpawnRarity);
        // Trees End

        saguaroSpawnRarity = configFile.get(WORLDGEN, "Saguaro Cactus Spawn Rarity", saguaroSpawnRarity).getInt(saguaroSpawnRarity);

        raspSpawnRarity = configFile.get(WORLDGEN, "Raspberry Spawn Rarity", raspSpawnRarity).getInt(raspSpawnRarity);
        raspSpawnRange = configFile.get(WORLDGEN, "Raspberry Spawn Range", raspSpawnRange).getInt(raspSpawnRange);
        blueSpawnRarity = configFile.get(WORLDGEN, "Blueberry Spawn Rarity", blueSpawnRarity).getInt(blueSpawnRarity);
        blueSpawnRange = configFile.get(WORLDGEN, "Blueberry Spawn Range", blueSpawnRange).getInt(blueSpawnRange);
        blackSpawnRarity = configFile.get(WORLDGEN, "Blackberry Spawn Rarity", blackSpawnRarity).getInt(blackSpawnRarity);
        blackSpawnRange = configFile.get(WORLDGEN, "Blackberry Spawn Range", blackSpawnRange).getInt(blackSpawnRange);
        maloSpawnRarity = configFile.get(WORLDGEN, "Maloberry Spawn Rarity", maloSpawnRarity).getInt(maloSpawnRarity);
        maloSpawnRange = configFile.get(WORLDGEN, "Maloberry Spawn Range", maloSpawnRange).getInt(maloSpawnRange);

        blightSpawnRarity = configFile.get(WORLDGEN, "Blightberry Spawn Rarity", blightSpawnRarity).getInt(blightSpawnRarity);
        blightSpawnRange = configFile.get(WORLDGEN, "Blightberry Spawn Range", blightSpawnRange).getInt(blightSpawnRange);
        duskSpawnRarity = configFile.get(WORLDGEN, "Duskberry Spawn Rarity", duskSpawnRarity).getInt(duskSpawnRarity);
        duskSpawnRange = configFile.get(WORLDGEN, "Duskberry Spawn Range", duskSpawnRange).getInt(duskSpawnRange);
        skySpawnRarity = configFile.get(WORLDGEN, "Skyberry Spawn Rarity", skySpawnRarity).getInt(skySpawnRarity);
        skySpawnRange = configFile.get(WORLDGEN, "Skyberry Spawn Range", skySpawnRange).getInt(skySpawnRange);
        stingSpawnRarity = configFile.get(WORLDGEN, "Stingberry Spawn Rarity", stingSpawnRarity).getInt(stingSpawnRarity);
        stingSpawnRange = configFile.get(WORLDGEN, "Stingberry Spawn Range", stingSpawnRange).getInt(stingSpawnRange);

        thornSpawnRarity = configFile.get(WORLDGEN, "Thornvines Spawn Rarity", thornSpawnRarity).getInt(thornSpawnRarity);

        seaLevel = configFile.get("general", "Sea level", seaLevel).getInt(seaLevel);

        // save changes if any
        boolean changed = false;
        if (configFile.hasChanged())
        {
            configFile.save();
            changed = true;
        }
        return changed;
    }

    //@formatter:off
    public static boolean enableRetrogen = false;

    public static int babyHeatscarMinimum = 2;
    public static int babyHeatscarMaximum = 4;

    public static int seaLevel = 64;

    public static boolean overrideNether = true;
    public static boolean canRespawnInNether = true;

    // Trees Start
    public static boolean generateRedwood = false;

    public static boolean generateMaple = true;
    public static boolean generateSilverbell = true;
    public static boolean generateAmaranth = true;
    public static boolean generateTiger = true;

    public static boolean generateWillow = true;
    public static boolean generateEucalyptus = true;
    public static boolean generateHopseed = true;
    public static boolean generateSakura = true;

    public static boolean generateBloodwood = true;
    public static boolean generateDarkwood = true;
    public static boolean generateFusewood = true;
    public static boolean generateGhostwood = true;

    public static int redwoodSpawnRarity = 150;

    public static int mapleRarity = 10;
    public static int silverbellRarity = 70;
    public static int amaranthRarity = 1;
    public static int tigerRarity = 30;

    public static int willowRarity = 10;
    public static int eucalyptusSpawnRarity = 25;
    public static int eucalyptusSpawnRange = 32;
    public static int hopseedSpawnRarity = 10;
    public static int hopseedSpawnRange = 20;
    public static int sakuraSpawnRarity = 10;
    public static int sakuraSpawnRange = 32;

    public static int bloodwoodSpawnRarity = 14;
    public static int darkwoodSpawnRarity = 10;
    public static int fusewoodSpawnRarity = 50;
    public static int ghostwoodSpawnRarity = 10;
    // Trees End

    //Overworld
    public static boolean generateBarley = true;
    public static boolean generateCotton = true;
    public static boolean generateBluebells = true;
    public static boolean generateBlueberries = true;
    public static boolean generateBlackberries = true;
    public static boolean generateRaspberries = true;
    public static boolean generateMaloberries = true;

    public static boolean generateBlightberries = true;
    public static boolean generateDuskberries = true;
    public static boolean generateSkyberries = true;
    public static boolean generateStingberries = true;

    public static boolean generateGreenglowshroom = true;
    public static boolean generatePurpleglowshroom = true;
    public static boolean generateBlueglowshroom = true;
    public static boolean generateGlowshroomtree = true;

    public static int saguaroSpawnRarity = 5;

    public static int raspSpawnRarity = 30;
    public static int raspSpawnRange = 64;
    public static int blueSpawnRarity = 34;
    public static int blueSpawnRange = 64;
    public static int blackSpawnRarity = 48;
    public static int blackSpawnRange = 64;
    public static int maloSpawnRarity = 40;
    public static int maloSpawnRange = 64;

    public static int blightSpawnRarity = 18;
    public static int blightSpawnRange = 100;
    public static int duskSpawnRarity = 18;
    public static int duskSpawnRange = 100;
    public static int skySpawnRarity = 18;
    public static int skySpawnRange = 100;
    public static int stingSpawnRarity = 18;
    public static int stingSpawnRange = 100;

    public static int thornSpawnRarity = 40;

    public static boolean generateSaguaro = true;

    public static boolean generateThornvines = true;

    public static boolean enableWheatRecipe = true;
    public static boolean dropBarley = true;
    public static boolean dropCotton = true;

    static Configuration configFile;
    //@formatter:on
}
