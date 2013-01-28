package com.cecilgwilliams.environments

public class EnvironmentFactory {

    def static environments = [:]

    public static Environment getDemo() {
        def env = environments.get "demo"
        if (env == null) {
            env = new DemoEnv()
            environments.put("demo", env)
        }
        env
    }

}
