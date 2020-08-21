# duct-todo

Source Code for [Clojure製Webフレームワーク Duct入門](https://www.amazon.co.jp/Clojure%E8%A3%BDWeb%E3%83%95%E3%83%AC%E3%83%BC%E3%83%A0%E3%83%AF%E3%83%BC%E3%82%AF-Duct%E5%85%A5%E9%96%80-%E3%83%80%E3%83%83%E3%82%AF%E3%82%BF%E3%82%A4%E3%83%94%E3%83%B3%E3%82%B0%E3%83%96%E3%83%83%E3%82%AF%E3%82%B9-%E9%A6%AC%E5%A0%B4-%E4%B8%80%E6%A8%B9-ebook/dp/B07J3KJZYS).

## Developing

### Setup

When you first clone this repository, run:

```sh
lein duct setup
```

This will create files for local configuration, and prep your system
for the project.

### Environment

To begin developing, start with a REPL.

```sh
lein repl
```

Then load the development environment.

```clojure
user=> (dev)
:loaded
```

Run `go` to prep and initiate the system.

```clojure
dev=> (go)
:duct.server.http.jetty/starting-server {:port 3000}
:initiated
```

By default this creates a web server at <http://localhost:3000>.

When you make changes to your source files, use `reset` to reload any
modified files and reset the server.

```clojure
dev=> (reset)
:reloading (...)
:resumed
```

### Testing

Testing is fastest through the REPL, as you avoid environment startup
time.

```clojure
dev=> (test)
...
```

But you can also run tests through Leiningen.

```sh
lein test
```

## Legal

Copyright © 2020 FIXME
