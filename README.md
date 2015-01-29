excelebration-maven-plugin
==========================

excelebration用のMavenプラグインです。

## Usage

```xml
<plugin>
  <groupId>org.apache.maven.plugin</groupId>
  <artifactId>excelebration-maven-plugin</artifactId>
  <version>0.1.0-SNAPSHOT</version>
  <configuration>
    <input>foo.md</input>
    <output>bar.xlsx</output>
  </configuration>
</plugin>
```

## Configuration

|パラメータ名|説明|
|:-----------|:---|
|input|入力ファイルパス|
|output|出力ファイルパス|
