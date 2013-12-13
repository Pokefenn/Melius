package melius_commons.pokefenn;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import melius_commons.pokefenn.lib.Strings;
import melius_commons.pokefenn.packet.PacketHandler;
import melius_commons.pokefenn.proxy.CommonProxy;
import melius_commons.pokefenn.util.CreativeTabMelius;
import net.minecraft.creativetab.CreativeTabs;

import java.util.logging.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: Pokefenn
 * Date: 13/12/13
 * Time: 12:46
 */

@Mod(modid = Strings.modid, name = Strings.name, version = Strings.version)
@NetworkMod(channels = { Strings.modid }, clientSideRequired = true, serverSideRequired = false, packetHandler = PacketHandler.class)
public class Melius {

    @Instance(Strings.modid)
    public static Melius instance;

    @SidedProxy(clientSide = Strings.CLIENT_PROXY_CLASS, serverSide = Strings.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;

    public static CreativeTabs tabsMelius = new CreativeTabMelius(CreativeTabs.getNextID(), Strings.modid);

    public static final Logger logger = Logger.getLogger(Strings.name);


    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {

        //ConfigurationHandler.init(new File(event.getModConfigurationDirectory().getAbsolutePath() + File.separator + Strings.modid + File.separator + Strings.name + ".cfg"));

        //ModBlocks.init();

    }

    @EventHandler
    public void load(FMLInitializationEvent event) {


    }



    @EventHandler
    public void modsLoaded(FMLPostInitializationEvent event) {


    }



}
