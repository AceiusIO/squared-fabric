package us.acei.squared
import net.fabricmc.api.ModInitializer
@Suppress("UNUSED")
object ModName: ModInitializer {
    private const val MOD_ID = "mod_id"
    override fun onInitialize() {
        println("Example mod has been initialized.")
    }
}