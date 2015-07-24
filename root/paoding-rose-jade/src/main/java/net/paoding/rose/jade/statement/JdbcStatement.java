/*
 * Copyright 2009-2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License i distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.paoding.rose.jade.statement;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import net.paoding.rose.jade.annotation.SQLType;

import org.apache.commons.lang.ClassUtils;

/**
 * 
 * @author qieqie
 * 
 */
public class JdbcStatement implements Statement {

    private final StatementMetaData metaData;

    private final Interpreter[] interpreters;

    private final Querier querier;

    private final boolean batchUpdate;

    private final SQLType sqlType;

    public JdbcStatement(StatementMetaData statementMetaData, SQLType sqlType,
            Interpreter[] interpreters, Querier querier) {
        this.metaData = statementMetaData;
        this.interpreters = (interpreters == null) ? new Interpreter[0] : interpreters;
        this.querier = querier;
        this.sqlType = sqlType;
        if (sqlType == SQLType.WRITE) {
            Method method = statementMetaData.getMethod();
            Class<?>[] types = method.getParameterTypes();
            Class<?> returnType = method.getReturnType();
            if (returnType.isPrimitive()) {
                returnType = ClassUtils.primitiveToWrapper(returnType);
            }
            if (types.length > 0 && List.class.isAssignableFrom(types[0])) {
                this.batchUpdate = true;
                if (returnType != void.class && returnType != int[].class
                        && returnType != Integer[].class && returnType != Integer.class) {
                    throw new IllegalArgumentException("error return type:"
                            + method.getDeclaringClass().getName() + "#" + method.getName() + "-->"
                            + returnType);
                }
            } else {
                this.batchUpdate = false;
                if (returnType != void.class && returnType != Boolean.class
                        && !Number.class.isAssignableFrom(returnType)) {
                    throw new IllegalArgumentException("error return type:"
                            + method.getDeclaringClass().getName() + "#" + method.getName() + "-->"
                            + returnType);
                }
            }
        } else {
            this.batchUpdate = false;
        }
    }

    @Override
    public StatementMetaData getMetaData() {
        return metaData;
    }

    @Override
    public Object execute(Map<String, Object> parameters) {
        if (batchUpdate) {
            //
            Iterable<?> iterable = (Iterable<?>) parameters.get(":1");
            Iterator<?> iterator = (Iterator<?>) iterable.iterator();
            List<StatementRuntime> runtimes = new LinkedList<StatementRuntime>();
            while (iterator.hasNext()) {
                Object arg = iterator.next();
                HashMap<String, Object> clone = new HashMap<String, Object>(parameters);
                // 更新执行参数
                clone.put(":1", arg);
                if (metaData.getSQLParamAt(0) != null) {
                    clone.put(metaData.getSQLParamAt(0).value(), arg);
                }
                StatementRuntime runtime = new StatementRuntimeImpl(metaData, clone);
                for (Interpreter interpreter : interpreters) {
                    interpreter.interpret(runtime);
                }
                runtimes.add(runtime);
            }
            return querier.execute(sqlType, runtimes.toArray(new StatementRuntime[0]));
        } else {
            StatementRuntime runtime = new StatementRuntimeImpl(metaData, parameters);
            for (Interpreter interpreter : interpreters) {
                interpreter.interpret(runtime);
            }
            return querier.execute(sqlType, runtime);
        }
    }

}
