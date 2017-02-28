一、mybatis代码自动生成。（表一定要设置主键，不然只会生成一个insert)
1、在pom中加	<plugin>
				<groupId>org.mybatis.generator</groupId>
				<artifactId>mybatis-generator-maven-plugin</artifactId>
				<version>1.3.2</version>
				<configuration>
					<verbose>true</verbose>
					<overwrite>true</overwrite>
				</configuration>
			</plugin>
2、resources目录加generatorConfig.xml配置文件
3、Maven Build… ——>在Goals框中输入：mybatis-generator:generate 
如果在命令行输入Maven命令即可，注意：一定是当前项目目录下运行该命令：
mvn mybatis-generator:generate