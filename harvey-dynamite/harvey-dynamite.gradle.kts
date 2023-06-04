version = "0.0.1"

project.extra["PluginName"] = "Harvey Dynamite"
project.extra["PluginDescription"] = "Deposits and withdraws all the shit we need from the bank. Very shit and hardcoded"

tasks {
    jar {
        manifest {
            attributes(mapOf(
                "Plugin-Version" to project.version,
                "Plugin-Id" to nameToId(project.extra["PluginName"] as String),
                "Plugin-Provider" to project.extra["PluginProvider"],
                "Plugin-Description" to project.extra["PluginDescription"],
                "Plugin-License" to project.extra["PluginLicense"]
            ))
        }
    }
}
