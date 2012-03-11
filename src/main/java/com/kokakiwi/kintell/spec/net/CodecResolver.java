/**
 *  This file is part of Kowy Maker - Specification.
 *
 *  Kowy Maker - Specification is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  Kowy Maker - Specification is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with Kowy Maker - Specification.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.kokakiwi.kintell.spec.net;

import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.Map;

import com.kokakiwi.kintell.spec.net.codec.*;
import com.kokakiwi.kintell.spec.net.msg.*;

/**
 * @author Koka El Kiwi
 * 
 */
public class CodecResolver
{
    private final Map<Byte, MessageCodec<? extends Message>>                       codecs   = new HashMap<Byte, MessageCodec<? extends Message>>();
    private final Map<Class<? extends Message>, MessageHandler<? extends Message>> handlers = new HashMap<Class<? extends Message>, MessageHandler<? extends Message>>();
    private final Map<Class<? extends Message>, Byte>                              opcodes  = new HashMap<Class<? extends Message>, Byte>();
    
    public CodecResolver()
    {
        // Init basic codecs
        try
        {
            registerCodec(ConnectMessageCodec.class);
            registerCodec(WorkspaceInitMessageCodec.class);
            registerCodec(SendSourceMessageCodec.class);
            registerCodec(CreateMachineMessageCodec.class);
            registerCodec(CreateProgramMessageCodec.class);
            registerCodec(BoardMessageCodec.class);
            registerCodec(ProgramsListMessageCodec.class);
            registerCodec(LaunchMessageCodec.class);
            registerCodec(StopMessageCodec.class);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    @SuppressWarnings("unchecked")
    public <T extends Message, V extends MessageCodec<T>> void registerCodec(
            Class<V> clazz) throws Exception
    {
        // Codec
        Constructor<V> constructor = clazz.getConstructor();
        V codec = constructor.newInstance();
        final Class<T> msgClazz = (Class<T>) ((ParameterizedType) clazz
                .getGenericSuperclass()).getActualTypeArguments()[0];
        registerCodec(msgClazz, codec);
    }
    
    public <T extends Message, V extends MessageCodec<T>> void registerCodec(
            Class<T> msgClazz, V codec)
    {
        codecs.put(codec.getOpcode(), codec);
        opcodes.put(msgClazz, codec.getOpcode());
    }
    
    @SuppressWarnings("unchecked")
    public <T extends Message, V extends MessageHandler<T>> void registerHandler(
            Class<V> clazz) throws Exception
    {
        Constructor<V> constructor = clazz.getConstructor();
        V handler = constructor.newInstance();
        final Class<T> msgClazz = (Class<T>) ((ParameterizedType) clazz
                .getGenericSuperclass()).getActualTypeArguments()[0];
        registerHandler(msgClazz, handler);
    }
    
    public <T extends Message, V extends MessageHandler<T>> void registerHandler(
            Class<T> msgClazz, V handler)
    {
        handlers.put(msgClazz, handler);
    }
    
    @SuppressWarnings("unchecked")
    public <V extends Message, T extends MessageCodec<V>> T getCodec(byte opcode)
    {
        return (T) codecs.get(opcode);
    }
    
    @SuppressWarnings("unchecked")
    public <V extends Message, T extends MessageCodec<V>> T getCodec(
            Class<V> clazz)
    {
        return (T) codecs.get(opcodes.get(clazz));
    }
    
    @SuppressWarnings("unchecked")
    public <V extends Message, T extends MessageHandler<V>> T getHandler(
            Class<V> clazz)
    {
        return (T) handlers.get(clazz);
    }
}
