import http from "k6/http";
import { check, sleep } from "k6";
// `options.stages to configure ramp up/down VU level
export let options = {
    stages: [
        { duration: "1m", target: 100},
        { duration: "1m", target: 300},
        { duration: "1m", target: 500},
        { duration: "1m", target: 0},
    ]
}
// this defines the entry point for your VUs
// similar to the main() function in many other language
export default function() {
    let res = http.get("http://localhost:8083/v1/products/20");

    // check() function to verify status code, transaction time etc
    check(res, {
        "status was 200": (r) => r.status == 200,
        "transaction time OK": (r) => r.timings.duration < 200
    });
    sleep(1);
}