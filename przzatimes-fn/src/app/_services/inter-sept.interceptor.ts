import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor
} from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable()
export class InterSeptInterceptor implements HttpInterceptor {

  constructor() {}

  intercept(request: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {
    const local_Token = localStorage.getItem('token')
    console.log(local_Token)
    request = request.clone({
                      headers: request.headers.set('Authorization','Bearer '+local_Token)
                      })
    console.log(request)
    return next.handle(request);
  }
}
