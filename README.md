# Final name suffix maven plugin

This Maven plugin sets finalName.suffix property.
When version contains SNAPSHOT, suffix is a timestamp, otherwise it is empty.

Usage:
```
    <build>
        <plugins>
            <plugin>
                <groupId>com.github.bepawel</groupId>
                <artifactId>final-name-suffix-maven-plugin</artifactId>
                <version>1.0</version>
                <executions>
                    <execution>
                        <phase>compile</phase>
                        <goals>
                            <goal>setFinalName</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>
        </plugins>
        <finalName>${artifactId}-${version}${finalName.suffix}</finalName>
    </build>
```