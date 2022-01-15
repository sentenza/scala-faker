# scala-faker

**scala-faker** is a library written in Scala which generates fake data such
as names, addresses, and phone numbers. It is a Scala port of the famous Ruby
library [faker]. It actually uses the same data for generating. 
This release of **scala-faker** is built against Scala `2.12`, `2.13` and `3.0`.

**scala-faker** only depends on [snakeyaml] for reading the original [faker]
yaml files. The tests are written with [scalatest].

## Usage

This section will give you a short introduction on how to get started with
scala-faker.

### Code

So how do I use it? Let's see ...

    import faker._ // That's all you need!

    case class User(name: String, username: String, email: String)

    val name = Name.name
    val user = User(name, Internet.user_name(name), Internet.free_email(name))
    // User(Kimi Hauke,kimihauke,haukekimi@hotmail.com)

Pretty easy, right?

#### Localization

By default **scala-faker** tries you systems locale for generating fake data. If there
isn't any localization for it (right now there are files for: `de-ch, de, en-gb, en-us,
en, nl`) it will fall back to `en`. The locale can be changed any time with
`Faker.locale(newLocale)`.

    import faker._

    // changing Language to german
    Faker.locale("de")

### Add dependency

Adding scala-faker as dependency to your project is really simple. Just add the following lines

#### sbt

for the latest stable release:

    libraryDependencies += "com.github.pjfanning" %% "scala-faker" % "0.5.3"

#### Maven

for the latest stable release:

    <dependency>
        <groupId>com.github.pjfanning</groupId>
        <artifactId>scala-faker_2.12</artifactId>
        <version>0.5.3</version>
    </dependency>

### Credits

This library uses the locales data from the ruby [faker] library.

## Contribution policy

Contributions via GitHub pull requests are gladly accepted from their original author.
Along with any pull requests, please state that the contribution is your original work
and that you license the work to the project under the project's open source license.
Whether or not you state this explicitly, by submitting any copyrighted material via pull
request, email, or other means you agree to license the material under the project's open
source license and warrant that you have the legal authority to do so.

## License

_scala-faker_ is licensed under the [Apache 2.0 License].

[faker]:https://github.com/stympy/faker
[tags]:https://github.com/justwrote/scala-faker/tags
[snakeyaml]:http://www.snakeyaml.org
[scalatest]:http://scalatest.org
[Apache 2.0 License]: http://www.apache.org/licenses/LICENSE-2.0
