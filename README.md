<h1 align="center">Simple Ktor Android Client(KtorApp)</h1>

<p align="center">
  <a href="https://android-arsenal.com/api?level=21"><img alt="API" src="https://img.shields.io/badge/API-21%2B-brightgreen.svg?style=flat"/></a>
</p>

<p align="center">  
KtorApp demonstrates modern Android development with Ktor, Koin, Coroutines, Flow, Jetpack (Room, ViewModel), and Material Design based on MVVM architecture.
</p>
</br>

## Open API

KtorApp using the [GITHUB API](https://api.github.com) for constructing RESTful API.<br>
KtorApp provides a RESTful API interface to highly detailed objects built from thousands of lines of data related to User List.

## Architecture
**KtorApp** is based on the MVVM architecture and the Repository pattern, which follows the [Google's official architecture guidance](https://developer.android.com/topic/architecture).

![architecture](readphoto/figure0.png)

The overall architecture of Pokedex is composed of two layers; the UI layer and the data layer. Each layer has dedicated components and they have each different responsibilities, as defined below:

KtorApp was built with Guide to app architecture, so it would be a great sample to show how the architecture works in real-world projects.

### UI Layer

![architecture](readphoto/figure2.png)
