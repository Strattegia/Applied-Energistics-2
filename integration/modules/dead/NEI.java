package appeng.integration.modules.dead;

import java.lang.reflect.Method;

import appeng.integration.IIntegrationModule;
import appeng.integration.modules.helpers.NEIQuartzShapedRecipeHandler;

public class NEI implements IIntegrationModule
{

	public static NEI instance;

	@Override
	public void Init() throws Throwable
	{
		Class API = Class.forName( "codechicken.nei.api.API" );
		Method registerRecipeHandler = API.getDeclaredMethod( "registerRecipeHandler", new Class[] { codechicken.nei.recipe.ICraftingHandler.class } );
		Method registerUsageHandler = API.getDeclaredMethod( "registerUsageHandler", new Class[] { codechicken.nei.recipe.IUsageHandler.class } );

		registerRecipeHandler.invoke( API, new NEIQuartzShapedRecipeHandler() );
		registerUsageHandler.invoke( API, new NEIQuartzShapedRecipeHandler() );

		/*
		 * Method registerGuiOverlay = API.getDeclaredMethod( "registerGuiOverlay", new Class[] { Class.class,
		 * String.class, int.class, int.class } ); Class IOverlayHandler = Class.forName(
		 * "codechicken.nei.api.IOverlayHandler" ); Class DefaultOverlayHandler =
		 * NEICraftingTerminalOverlayHandler.class; Method registerGuiOverlayHandler = API.getDeclaredMethod(
		 * "registerGuiOverlayHandler", new Class[] { Class.class, IOverlayHandler, String.class } );
		 * registerGuiOverlay.invoke( API, GuiCraftingTerminal.class, "crafting", 6, 75 ); Constructor
		 * DefaultOverlayHandlerConstructor = DefaultOverlayHandler .getConstructor( new Class[] { int.class, int.class
		 * } ); registerGuiOverlayHandler.invoke( API, GuiCraftingTerminal.class,
		 * DefaultOverlayHandlerConstructor.newInstance( 6, 75 ), "crafting" );
		 */
	}

	@Override
	public void PostInit() throws Throwable
	{

	}

}