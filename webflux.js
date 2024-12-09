import http from 'k6/http';
import { sleep } from 'k6';

export const options = {
    vus: 100,
    duration: '15s',
};

export default function () {
    const url = 'http://localhost:8080/webflux/hello';
    const response = http.get(url);

    if (response.status !== 200) {
        console.error(`Request failed: ${response.status}`);
    }

    sleep(0.1); // Ждём 100 мс между запросами (симуляция задержки)
}
