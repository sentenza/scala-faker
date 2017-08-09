sonatypeProfileName := "it.bitbl"

useGpg := true
usePgpKeyHex("5981BDBD")

publishMavenStyle := true
publishArtifact in Test := false
pomIncludeRepository := (_ => false)

