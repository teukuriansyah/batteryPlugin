// swift-tools-version: 5.9
import PackageDescription

let package = Package(
    name: "Battery",
    platforms: [.iOS(.v15)],
    products: [
        .library(
            name: "Battery",
            targets: ["batteryPlugin"])
    ],
    dependencies: [
        .package(url: "https://github.com/ionic-team/capacitor-swift-pm.git", from: "8.0.0")
    ],
    targets: [
        .target(
            name: "batteryPlugin",
            dependencies: [
                .product(name: "Capacitor", package: "capacitor-swift-pm"),
                .product(name: "Cordova", package: "capacitor-swift-pm")
            ],
            path: "ios/Sources/batteryPlugin"),
        .testTarget(
            name: "batteryPluginTests",
            dependencies: ["batteryPlugin"],
            path: "ios/Tests/batteryPluginTests")
    ]
)