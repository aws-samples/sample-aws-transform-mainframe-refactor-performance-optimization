export JAVA_HOME="/Library/Java/JavaVirtualMachines/amazon-corretto-21.jdk/Contents/Home"
export CATALINA_OPTS="$CATALINA_OPTS -Xms1g -Xmx4g -Dlogback.ContextSelector=JNDI -Dslf4j.provider=com.netfective.bluage.gapwalk.logging.GapwalkLogbackServiceProvider"
