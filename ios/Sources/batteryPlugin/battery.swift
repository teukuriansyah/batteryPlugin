import Foundation

@objc public class battery: NSObject {
    @objc public func echo(_ value: String) -> String {
        print(value)
        return value
    }
}
