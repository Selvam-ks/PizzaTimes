import { TestBed } from '@angular/core/testing';

import { InterSeptInterceptor } from './inter-sept.interceptor';

describe('InterSeptInterceptor', () => {
  beforeEach(() => TestBed.configureTestingModule({
    providers: [
      InterSeptInterceptor
      ]
  }));

  it('should be created', () => {
    const interceptor: InterSeptInterceptor = TestBed.inject(InterSeptInterceptor);
    expect(interceptor).toBeTruthy();
  });
});
